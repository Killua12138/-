package Copyto;

import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

public class DESUtil {
    public DESUtil() {

    }
    //密码，长度要是8的倍数    注意此处为简单密码  简单应用 要求不高时可用此密码
/*DES是一种对称加密算法，所谓对称加密算法即：加密和解密使用相同密钥的算法。DES加密算法出自IBM的研究，
后来被美国政府正式采用，之后开始广泛流传，但是近些年使用越来越少，因为DES使用56位密钥，以现代计算能力，
24小时内即可被破解。*/

    private static String password = "9588888888880288";
    //测试
    public static void main(String args[]) {
        //待加密内容
        String str = "task_id=TSK_000000006870&ledger_id=0715-5572";

        String result = DESUtil.encrypt(str);

        BASE64Encoder base64en = new BASE64Encoder();
//        String strs = new String(base64en.encode(result));

        System.out.println("加密后："+result);
        //直接将如上内容解密
        try {
            String decryResult = DESUtil.decryptor(result);
            System.out.println("解密后："+new String(decryResult));
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
    /**
     *
     * @Method: encrypt
     * @Description: 加密数据
     * @param data
     * @return
     * @throws Exception
     * @date 2016年7月26日
     */
    public static String encrypt(String data) {  //对string进行BASE64Encoder转换
        byte[] bt = encryptByKey(data.getBytes(), password);
        BASE64Encoder base64en = new BASE64Encoder();
        String strs = new String(base64en.encode(bt));
        return strs;
    }
    /**
     *
     * @Method: encrypt
     * @Description: 解密数据
     * @param data
     * @return
     * @throws Exception
     * @date 2016年7月26日
     */
    public static String decryptor(String data) throws Exception {  //对string进行BASE64Encoder转换
        sun.misc.BASE64Decoder base64en = new sun.misc.BASE64Decoder();
        byte[] bt = decrypt(base64en.decodeBuffer(data), password);
        String strs = new String(bt);
        return strs;
    }
    /**
     * 加密
     * @param datasource byte[]
     * @param password String
     * @return byte[]
     */
    private static byte[] encryptByKey(byte[] datasource, String key) {
        try{
            SecureRandom random = new SecureRandom();

            DESKeySpec desKey = new DESKeySpec(key.getBytes());
            //创建一个密匙工厂，然后用它把DESKeySpec转换成
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            //Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES");
            //用密匙初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
            //现在，获取数据并加密
            //正式执行加密操作
            return cipher.doFinal(datasource);
        }catch(Throwable e){
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 解密
     * @param src byte[]
     * @param password String
     * @return byte[]
     * @throws Exception
     */
    private static byte[] decrypt(byte[] src, String key) throws Exception {
        // DES算法要求有一个可信任的随机数源
        SecureRandom random = new SecureRandom();
        // 创建一个DESKeySpec对象
        DESKeySpec desKey = new DESKeySpec(key.getBytes());
        // 创建一个密匙工厂
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        // 将DESKeySpec对象转换成SecretKey对象
        SecretKey securekey = keyFactory.generateSecret(desKey);
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance("DES");
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, random);
        // 真正开始解密操作
        return cipher.doFinal(src);
    }
}
