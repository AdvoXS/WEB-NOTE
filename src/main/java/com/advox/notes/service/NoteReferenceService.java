package com.advox.notes.service;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class NoteReferenceService {
    public String getReference(String ref) {
        Pattern HTTP_START_PATTERN = Pattern.compile("^https://|^http:");
        if (!HTTP_START_PATTERN.matcher(ref).find()) {
            return "https://" + ref;
        } else return ref;
    }
}
