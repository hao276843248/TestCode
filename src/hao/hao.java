package hao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class hao {

	static byte[] data = null;

	public static void main(String[] args) {

		try {
			// read file content from file
			StringBuffer sb = new StringBuffer("");
			FileReader reader = new FileReader("f://zy1.txt");
			BufferedReader br = new BufferedReader(reader);
			String str = null;
			File file = new File("touxiang.flv");
			FileOutputStream outputStream = new FileOutputStream(file);
			while ((str = br.readLine()) != null) {
				if (str.indexOf("http") > -1) {
					byte[] b = getInputStream(str);
					System.out.println(str);
					outputStream.write(b);
				}
			}
			br.close();
			reader.close();
			outputStream.close();
		} catch (Exception e) {

		}
	}

	public static byte[] getInputStream(String urlPath) throws Exception {
		// ����Ҫ��ȡ�����·����·������Ҫ�����ϻ�ȡ����Դ
		// String urlPath=
		// "http://106.38.249.42/67790B11E0636796035EB61DC/030001080758C233987EA9011BA6A95FF3E21C-AE1A-DF03-B194-9AD4DC270AC3.flv.ts?sid=4489587736000216ed1d1_07&sign=e71e234588ae521c7ff2257f80ad8ad9&ctype=21&ts_start=102.544&ts_end=112.387&ts_seg_no=143&ts_keyframe=1";
		URL url = new URL(urlPath);// ����URL������׳��쳣
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();// �õ�UrlConnection����
		byte[] b =null;
		conn.setConnectTimeout(60 * 1000);// �������ӳ�ʱ
		if (conn.getResponseCode() == 200) {// ��������200���ʹ������������ǳɹ���
			InputStream inputStream = conn.getInputStream();// �õ��������˴����������ݣ���Կͻ���Ϊ������
			b =readInstream(inputStream);
		}
		return b;
	}

	private static byte[] readInstream(InputStream inputStream) throws Exception {
		ByteArrayOutputStream byteArrayOutPutStream = new ByteArrayOutputStream();// ����ByteArrayOutputStream��
		byte[] buffer = new byte[1024];// ����������
		int length = -1;// �����ȡ��Ĭ�ϳ���
		while ((length = inputStream.read(buffer)) != -1) {
			byteArrayOutPutStream.write(buffer, 0, length);// �ѻ������е����뵽�ڴ���
		}
		;
		byteArrayOutPutStream.close();// �ر�������
		inputStream.close();// �ر�������

		return byteArrayOutPutStream.toByteArray();// ����������������ֽ�����
	}

}
