package com.taotao.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface PictureService {

	Map<String, Object> uploadPicture(MultipartFile uploadfile);
}
