package com.coding.common;


public class ColorUtil {

    public static LedOrderUtil.ColorItem wavelengthToRGB(int wavelength) {
        double Gamma = 0.8;
        int IntensityMax = 255;

        double blue;
        double green;
        double red;
        double factor;

        if (wavelength >= 380 && wavelength <= 439) {
            red = -(wavelength - 440d) / (440d - 350d);
            green = 0.0;
            blue = 1.0;
        } else if (wavelength >= 440 && wavelength <= 489) {
            red = 0.0;
            green = (wavelength - 440d) / (490d - 440d);
            blue = 1.0;
        } else if (wavelength >= 490 && wavelength <= 509) {
            red = 0.0;
            green = 1.0;
            blue = -(wavelength - 510d) / (510d - 490d);
        } else if (wavelength >= 510 && wavelength <= 579) {
            red = (wavelength - 510d) / (580d - 510d);
            green = 1.0;
            blue = 0.0;
        } else if (wavelength >= 580 && wavelength <= 644) {
            red = 1.0;
            green = -(wavelength - 645d) / (645d - 580d);
            blue = 0.0;
        } else if (wavelength >= 645 && wavelength <= 780) {
            red = 1.0;
            green = 0.0;
            blue = 0.0;
        } else {
            red = 0.0;
            green = 0.0;
            blue = 0.0;
        }

        if (wavelength >= 350 && wavelength <= 419) {
            factor = 0.3 + 0.7 * (wavelength - 380d) / (420d - 380d);
        } else if (wavelength >= 420 && wavelength <= 700) {
            factor = 1.0;
        } else if (wavelength >= 701 && wavelength <= 780) {
            factor = 0.3 + 0.7 * (780d - wavelength) / (780d - 700d);
        } else {
            factor = 0.0;
        }

        int r = adjust(red, factor, IntensityMax, Gamma);
        int g = adjust(green, factor, IntensityMax, Gamma);
        int b = adjust(blue, factor, IntensityMax, Gamma);

        return new LedOrderUtil.ColorItem(r, g, b);
    }

    private static int adjust(double color, double factor, int intensityMax, double gamma) {
        if (color == 0.0) {
            return 0;
        } else {
            return (int) Math.round(intensityMax * Math.pow(color * factor, gamma));
        }
    }


    /**
     * 将颜色字符串转换成颜色数据 比如 #FF0000 转换成 (r=255, g=0, b=0)
     *
     * @param colorStr 颜色字符串
     * @return dd
     */
    public static LedOrderUtil.ColorItem toColor(String colorStr) {
        if (colorStr == null || colorStr.length() != 7) {
            return null;
        }
        colorStr = colorStr.replace("#", "");
        int sum = Integer.parseInt(colorStr, 16);
        int r = sum / 256 / 256;
        int g = sum / 256 % 256;
        int b = sum % 256;
        return new LedOrderUtil.ColorItem(r, g, b);
    }

    public static void main(String[] args) {
        System.out.println(wavelengthToRGB(579).getContent());
        System.out.println(toColor("#ff1100").getContent());
    }
}
