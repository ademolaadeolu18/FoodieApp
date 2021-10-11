package com.config;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadImageService {

	Regions clientRegion = Regions.US_EAST_2;
	String bucketName = "tobi-aws-bucket1";
	String folderName = "UserImages";

	public String uploadFile(String fileName, MultipartFile file) throws IOException {
		try {
			AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion(clientRegion).build();

			String fileType = file.getContentType().toString()
					.substring(file.getContentType().toString().indexOf("/") + 1);
			fileName = String.format("%s/%s.%s", folderName, fileName, fileType);

			PutObjectRequest request = new PutObjectRequest(bucketName, fileName, convertMultiPartToFile(file));
			ObjectMetadata metadata = new ObjectMetadata();
			metadata.setContentType(file.getContentType());
			s3Client.putObject(request);
			return s3Client.getUrl(bucketName, fileName).getPath();
		} catch (SdkClientException e) {

			e.printStackTrace();
			return null;
		}
	}

	private File convertMultiPartToFile(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}

}
