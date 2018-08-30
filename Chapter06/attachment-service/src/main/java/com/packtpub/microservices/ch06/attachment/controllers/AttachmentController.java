package com.packtpub.microservices.ch06.attachment.controllers;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.packtpub.microservices.ch06.attachment.config.Configuration;
import com.packtpub.microservices.ch06.attachment.data.AttachmentRepository;
import com.packtpub.microservices.ch06.attachment.exceptions.AttachmentNotFoundException;
import com.packtpub.microservices.ch06.attachment.models.Attachment;
import com.packtpub.microservices.ch06.attachment.models.AttachmentRequest;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

@RestController
public class AttachmentController {

    @Autowired
    private AttachmentRepository attachmentRepository;

    @Autowired
    private AmazonS3 s3Client;

    @Value("${s3.bucket-name}")
    private String bucketName;

    @Autowired
    private Configuration config;

    @RequestMapping(path = "/message/{message_id}/attachments", method = RequestMethod.GET, produces = "application/json")
    public List<Attachment> getAttachments(@PathVariable("message_id") String messageId) {
        List<Attachment> attachments = attachmentRepository.findByMessageId(messageId);
        if (attachments.isEmpty()) {
            throw new AttachmentNotFoundException();
        }
        return attachments;
    }

    @RequestMapping(path = "/message/{message_id}/attachments", method = RequestMethod.POST, produces = "application/json")
    public Attachment create(@PathVariable("message_id") String messageId, @RequestBody AttachmentRequest request) {

        byte[] byteArray = Base64.decodeBase64(request.getData());

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(byteArray.length);
        metadata.setContentType("image/jpeg");
        metadata.setCacheControl("public, max-age=31536000");
        InputStream stream = new ByteArrayInputStream(byteArray);

        String fullyResolved = String.format("%s/%s", messageId, request.getFileName());

        s3Client.putObject(
            new PutObjectRequest(bucketName, fullyResolved, stream, metadata)
                .withCannedAcl(CannedAccessControlList.PublicRead));

        String url = String.format("https://%s.s3.amazonaws.com/%s", bucketName, fullyResolved);

        Attachment attachment = new Attachment(messageId, url, request.getFileName(), 1);
        attachmentRepository.save(attachment);
        return attachment;
    }
}
