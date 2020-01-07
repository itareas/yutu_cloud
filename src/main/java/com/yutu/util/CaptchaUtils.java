package com.yutu.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 封装验证码图片生成的工具类
 *
 * @author Administrator
 */
public class CaptchaUtils {

    private static List<String> list = new ArrayList<>();

    /*
     * 随机生成字符字典
     */
    private static final char[] CHARS = {'2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

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
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    /*
     * 返回某颜色的反色
     */

    public static Color getReverseColor(Color c) {
        return new Color(255 - c.getRed(), 255 - c.getGreen(), 255 - c.getBlue());
    }

    public static void outputCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg");
        String randomString = getRandomString();

        if (list.size() > 0) {
            list.clear();
            list.add(randomString);
        } else {
            list.add(randomString);
        }
        int Width = 130;
        int height = 40;

        //color
        Color color = getRamColor();
        Color reverse = getReverseColor(color);
        //生成只有红、绿、蓝色图片
        BufferedImage bi = new BufferedImage(Width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        g.setColor(color);
        g.fillRect(0, 0, Width, height);
        g.setColor(reverse);
        g.drawString(randomString, 18, 30);
        //生成10条干扰线；
        for (int i = 0; i < 20; i++) {
            int x = random.nextInt(Width);
            int y = random.nextInt(height);
            int x1 = random.nextInt(12);
            int y1 = random.nextInt(12);
            g.drawLine(x, y, x + x1, y + y1);
        }
        for (int i = 0, n = random.nextInt(100); i < n; i++) {
            g.drawRect(random.nextInt(Width), random.nextInt(height), 1, 1);
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
