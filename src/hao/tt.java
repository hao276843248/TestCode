package hao;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;

public class tt {

//	 	@Test
//	    public void test() {
//	        fail("Not yet implemented");
//	    }
	    @Test
	    public void getImage() throws Exception{
	        //����Ҫ��ȡ�����·����·������Ҫ�����ϻ�ȡ����Դ
	        String urlPath= "http://106.38.249.42/67790B11E0636796035EB61DC/030001080758C233987EA9011BA6A95FF3E21C-AE1A-DF03-B194-9AD4DC270AC3.flv.ts?sid=4489587736000216ed1d1_07&sign=e71e234588ae521c7ff2257f80ad8ad9&ctype=21&ts_start=102.544&ts_end=112.387&ts_seg_no=143&ts_keyframe=1";
	        URL url = new URL(urlPath);//����URL������׳��쳣
	        HttpURLConnection conn =(HttpURLConnection)url.openConnection();//�õ�UrlConnection����

	        conn.setRequestMethod("GET");//��������ʽ
	        conn.setConnectTimeout(6*1000);//�������ӳ�ʱ
	        if(conn.getResponseCode() == 200){//��������200���ʹ������������ǳɹ���
	            InputStream inputStream = conn.getInputStream();//�õ��������˴����������ݣ���Կͻ���Ϊ������

	            byte[] data = readInstream(inputStream);
	            File file = new File("touxiang.MP4");
	            FileOutputStream outputStream = new FileOutputStream(file);
	            outputStream.write(data);
	            outputStream.close();       
	        }       
	    }

	    private byte[] readInstream(InputStream inputStream) throws Exception{
	        ByteArrayOutputStream byteArrayOutPutStream = new ByteArrayOutputStream();//����ByteArrayOutputStream��
	        byte[] buffer = new byte[1024];//����������
	        int length = -1;//�����ȡ��Ĭ�ϳ���
	        while((length = inputStream.read(buffer))!= -1){
	            byteArrayOutPutStream.write(buffer,0,length);//�ѻ������е����뵽�ڴ���         
	        };
	        byteArrayOutPutStream.close();//�ر�������
	        inputStream.close();//�ر�������

	        return byteArrayOutPutStream.toByteArray();//����������������ֽ�����
	    }
}
