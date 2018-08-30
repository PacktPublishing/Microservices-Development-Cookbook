package com.packtpub.microservices.ch06.attachment.data;

import com.packtpub.microservices.ch06.attachment.models.Attachment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AttachmentRepository extends CrudRepository<Attachment, String> {
    public List<Attachment> findByMessageId(String messageId);
}
