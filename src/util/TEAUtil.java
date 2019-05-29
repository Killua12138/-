package util;

public class TEAUtil {
    //加密
    public byte[] encrypt(byte[] content, int offset, int[] key, int times) {//times为加密轮数
        int[] tempInt = byteToInt(content, offset);
        int y = tempInt[0], z = tempInt[1], sum = 0, i;
        int delta = 0x9e3779b9; //这是算法标准给的值
        int a = key[0], b = key[1], c = key[2], d = key[3];

        for (i = 0; i < times; i++) {
            sum += delta;
            y += ((z << 4) + a) ^ (z + sum) ^ ((z >> 5) + b);
            z += ((y << 4) + c) ^ (y + sum) ^ ((y >> 5) + d);
        }
        tempInt[0] = y;
        tempInt[1] = z;
        return intToByte(tempInt, 0);
    }

    //解密
    public byte[] decrypt(byte[] encryptContent, int offset, int[] key, int times) {
        int[] tempInt = byteToInt(encryptContent, offset);
        int y = tempInt[0], z = tempInt[1], sum = 0xC6EF3720, i;
        int delta = 0x9e3779b9; //这是算法标准给的值
        int a = key[0], b = key[1], c = key[2], d = key[3];
        for (i = 0; i < times;
             i++) {
            z -= ((y << 4) + c) ^ (y + sum) ^ ((y >> 5) + d);
            y -= ((z << 4) + a) ^ (z + sum) ^ ((z >> 5) + b);
            sum -= delta;
        }
        tempInt[0] = y;
        tempInt[1] = z;

        return intToByte(tempInt, 0);
    }

    //byte[]型数据转成int[]型数据
    private int[] byteToInt(byte[] content, int offset) {

        int[] result = new int[content.length >> 2]; //除以2的n次方 == 右移n位 即 content.length / 4 == content.length ＞＞ 2
        for (int i = 0, j = offset; j < content.length;
             i++, j += 4) {
            result[i] = transform(content[j + 3]) | transform(content[j + 2]) << 8 |
                    transform(content[j + 1]) << 16 | (int) content[j] << 24;
        }
        return result;

    }

    //int[]型数据转成byte[]型数据
    private byte[] intToByte(int[] content, int offset) {
        byte[] result = new byte[content.length << 2]; //乘以2的n次方 == 左移n位 即 content.length * 4 == content.length ＜＜ 2
        for (int i = 0, j = offset; j < result.length;
             i++, j += 4) {
            result[j + 3] = (byte) (content[i] & 0xff);
            result[j + 2] = (byte) ((content[i] >> 8) & 0xff);
            result[j + 1] = (byte) ((content[i] >> 16) & 0xff);
            result[j] = (byte) ((content[i] >> 24) & 0xff);
        }
        return result;
    }

    //若某字节被解释成负的则需将其转成无符号正数
    private static int transform(byte temp) {
        int tempInt = (int) temp;
        if (tempInt < 0) {
            tempInt += 256;
        }
        return tempInt;
    }

    public static byte[] long2Bytes(long num) {
        byte[] byteNum = new byte[8];
        for (int ix = 0; ix < 8; ++ix) {
            int offset = 64 - (ix + 1) * 8;
            byteNum[ix] = (byte) ((num >> offset) & 0xff);
        }
        return byteNum;
    }

    public static long bytes2Long(byte[] byteNum) {
        long num = 0;
        for (int ix = 0; ix < 8; ++ix) {
            num <<= 8;
            num |= (byteNum[ix] & 0xff);
        }
        return num;
    }

    public static void main(String[] args) {

        int[] KEY = new int[]{//加密解密所用的KEY
                0xA56BABCD, 0x00000000,
                0xFFFFFFFF, 0xABCDEF01
        };
        TEAUtil tea = new TEAUtil();
        String str = "0123456789ABCDEF";
        long num = Long.parseLong(str,16);
        System.out.println(Long.toHexString(num));
        byte[] info = long2Bytes(num);
        System.out.print("原数据：");
        for (byte i : info)
            System.out.print(i + " ");
        System.out.println();
        byte[] secretInfo = tea.encrypt(info, 0, KEY, 32);
        System.out.print("加密后的数据：");
        for (byte i : secretInfo)
            System.out.print(i + " ");
        System.out.println();
        System.out.println(Long.toHexString(bytes2Long(secretInfo)));

        byte[] decryptInfo = tea.decrypt(secretInfo, 0, KEY, 32);
        System.out.print("解密后的数据：");
        for (byte i : decryptInfo)
            System.out.print(i + " ");
        System.out.println();
        System.out.println(Long.toHexString(bytes2Long(decryptInfo)));
    }
}
