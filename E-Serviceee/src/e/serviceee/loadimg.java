/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package e.serviceee;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author ASUS
 */
public class loadimg {
    public static BufferedImage loadImage(String urlGambar){
        BufferedImage bimg = null;
        try {
            bimg = ImageIO.read(new File(urlGambar) );
        } catch (IOException e) {
            System.out.println("gagal load gambar;"+e.getMessage());
        }
        return bimg;
    }
    
}
