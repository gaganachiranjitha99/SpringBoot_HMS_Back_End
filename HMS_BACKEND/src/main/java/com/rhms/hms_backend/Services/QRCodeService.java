package com.rhms.hms_backend.Services;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Service
public class QRCodeService {

    public String saveQRCode(MultipartFile qrCodeImage) throws IOException, NotFoundException {
        // Process the QR code image and return the decoded data
        try {
            BufferedImage image = ImageIO.read(qrCodeImage.getInputStream());
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(
                    new BufferedImageLuminanceSource(image)));
            Result qrCodeResult = new MultiFormatReader().decode(binaryBitmap);

            if (qrCodeResult != null) {
                return qrCodeResult.getText();
            } else {
                return null;
            }
        } catch (IOException | NotFoundException e) {
            throw e;
        }
    }
}
