package com.yutu.util;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author: zhaobc
 * @Date: 2020/1/12 17:37
 * @Description:
 */
public class CaptchaUtils {
    private static List<String> list = new ArrayList<String>();

    /*
     * 随机生成字符字典
     */
    private static final char[] CHARS = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

    /*
     * 随机数
     */
    private static Random random = new Random();

    /*
     * 获取6位随机数
     */

    private static String getRandomString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            stringBuffer.append(CHARS[random.nextInt(CHARS.length)]);

        }
        return stringBuffer.toString();
    }

    /*
     * 获取随机颜色
     */

    private static Color getRamColor() {
        return new Color(0, 0, 0,0);
    }

    /*
     * 返回某颜色的反色
     */

    public static Color getReverseColor() {
        return new Color(random.nextInt(100)+155, random.nextInt(100)+155, random.nextInt(100)+155);
    }

    public static void outputCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int width=100;
        int height=40;
        String strWidth = request.getParameter("width");
        if (strWidth != null) {
            width = Integer.parseInt(strWidth);
        }
        String strHeight = request.getParameter("height");
        if (strHeight != null) {
            height = Integer.parseInt(strHeight);
        }
        response.setContentType("image/jpeg");
        String randomString = getRandomString();

        if (list.size() > 0) {
            list.clear();
            list.add(randomString);
        } else {
            list.add(randomString);
        }

        //color
        Color color = getRamColor();
        Color reverse = getReverseColor();
        //生成只有红、绿、蓝色图片
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D g = bi.createGraphics();
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        g.setColor(color);
        g.fillRect(0, 0, width, height);
        g.setColor(reverse);
        g.drawString(randomString, 12, 25);
        //生成10条干扰线；
        for (int i = 0; i < 20; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int x1 = random.nextInt(12);
            int y1 = random.nextInt(12);
            g.drawLine(x, y, x + x1, y + y1);
        }
        for (int i = 0, n = random.nextInt(100); i < n; i++) {
            g.drawRect(random.nextInt(width), random.nextInt(height), 1, 1);
        }
        //转成JPEG格式
        ServletOutputStream out = response.getOutputStream();
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        encoder.encode(bi);
        out.flush();
    }

    //获取验证码
    public static String getCaptchas() {
        String captcha = "";
        for (String str : list) {
            captcha = str;
        }
        return captcha;
    }
}
