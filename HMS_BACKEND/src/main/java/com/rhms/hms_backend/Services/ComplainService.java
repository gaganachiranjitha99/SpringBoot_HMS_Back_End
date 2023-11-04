package com.rhms.hms_backend.Services;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.encoder.QRCode;
import com.rhms.hms_backend.Models.Complain;
import com.rhms.hms_backend.Models.ResolvedComplain;
import com.rhms.hms_backend.Models.ResolvedComplainCopy;
import com.rhms.hms_backend.Models.SubwardenComplains;
import com.rhms.hms_backend.Repositories.ComplainRepo;
import com.rhms.hms_backend.Repositories.ComplainResolvedRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;


@Service

public class ComplainService {

   @Autowired
   private ComplainRepo complainRepo;

   @Autowired
   private ComplainResolvedRepo complainResolvedRepo;

    public Complain createComplain(Complain complain) {
        return complainRepo.save(complain);
    }

    public void updateComplain(Complain complaint,Long id){
        complainRepo.save(complaint);
    }
    public void Save(Complain complaint){
        complainRepo.save(complaint);
    }


    public Complain getById(Long id){
        Optional<Complain> optionalComplaint = complainRepo.findById(id);

        if (optionalComplaint.isPresent()) {
            return optionalComplaint.get();
        } else {
            throw new EntityNotFoundException("Complain with ID " + id + " not found");
        }
    }


    public List<Complain> getAllComplains(){
        List<Complain> complains = new ArrayList<>();
        complainRepo.findAll().forEach(complain -> complains.add(complain));
        return complains;
    }

    public void delete(Long id) {
        complainRepo.deleteById(id);
    }


    @Transactional
    public Complain saveQRCode(String c_itemcode) throws IOException, NotFoundException {
        byte[] decodedImage = Base64.getDecoder().decode(c_itemcode);

        // Convert the decoded image bytes to a BufferedImage
        ByteArrayInputStream bis = new ByteArrayInputStream(decodedImage);
        BufferedImage image = ImageIO.read(bis);

        // Decode the QR code from the BufferedImage
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(
                new BufferedImageLuminanceSource(image)));
        Result qrCodeResult = new MultiFormatReader().decode(binaryBitmap);

        if (qrCodeResult != null) {
            String qrCodeData = qrCodeResult.getText();

            // Save the QR code data to the database
            Complain complain = new Complain();
            complain.setC_itemcode(c_itemcode);
            return complainRepo.save(complain);
        } else {
            return null;
        }
    }


    public List<Complain> getComplainsByUserId(String user_index) {
        return complainRepo.findByUserIndex(user_index);
    }


    @Transactional
    public List<ResolvedComplain> getAllResolvedComplains() {
        return complainResolvedRepo.all_resolved_complain_view();
    }



}
