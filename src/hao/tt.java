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
	        //首先要获取请求的路径，路径就是要从网上获取的资源
	        String urlPath= "http://106.38.249.42/67790B11E0636796035EB61DC/030001080758C233987EA9011BA6A95FF3E21C-AE1A-DF03-B194-9AD4DC270AC3.flv.ts?sid=4489587736000216ed1d1_07&sign=e71e234588ae521c7ff2257f80ad8ad9&ctype=21&ts_start=102.544&ts_end=112.387&ts_seg_no=143&ts_keyframe=1";
	        URL url = new URL(urlPath);//建立URL类对象，抛出异常
	        HttpURLConnection conn =(HttpURLConnection)url.openConnection();//得到UrlConnection对象

	        conn.setRequestMethod("GET");//声明请求方式
	        conn.setConnectTimeout(6*1000);//设置连接超时
	        if(conn.getResponseCode() == 200){//如果结果是200，就代表他的请求是成功的
	            InputStream inputStream = conn.getInputStream();//得到服务器端传回来的数据，相对客户端为输入流

	            byte[] data = readInstream(inputStream);
	            File file = new File("touxiang.MP4");
	            FileOutputStream outputStream = new FileOutputStream(file);
	            outputStream.write(data);
	            outputStream.close();       
	        }       
	    }

	    private byte[] readInstream(InputStream inputStream) throws Exception{
	        ByteArrayOutputStream byteArrayOutPutStream = new ByteArrayOutputStream();//创建ByteArrayOutputStream类
	        byte[] buffer = new byte[1024];//声明缓存区
	        int length = -1;//定义读取的默认长度
	        while((length = inputStream.read(buffer))!= -1){
	            byteArrayOutPutStream.write(buffer,0,length);//把缓存区中的输入到内存中         
	        };
	        byteArrayOutPutStream.close();//关闭输入流
	        inputStream.close();//关闭输入流

	        return byteArrayOutPutStream.toByteArray();//返回这个输入流的字节数组
	    }
}
