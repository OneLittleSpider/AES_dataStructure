import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static SecretKey keyGenerator() throws NoSuchAlgorithmException{
        KeyGenerator keyGenerator=KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey key=keyGenerator.generateKey();
        return key;

    }

    public static IvParameterSpec ivGenerator(){
        byte[] iv =new byte[16];
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }

    public static void addRoundKey(byte[] state, byte[] key){
        for(int i=0;i< state.length;i++){
            state[i]^=key[i];
        }
    }

    private static final byte[][] S_BOX = {
            {(byte) 0x63, (byte) 0x7c, (byte) 0x77, (byte) 0x7b, (byte) 0xf0, (byte) 0x87, (byte) 0x7f, (byte) 0x7d,
                    (byte) 0x93, (byte) 0x26, (byte) 0x36, (byte) 0x3f, (byte) 0xf7, (byte) 0xcc, (byte) 0x34, (byte) 0xa5},

            {(byte) 0xe5, (byte) 0xf1, (byte) 0x71, (byte) 0xd8, (byte) 0x31, (byte) 0x15, (byte) 0x04, (byte) 0xc7,
                    (byte) 0x23, (byte) 0xc3, (byte) 0x18, (byte) 0x96, (byte) 0x05, (byte) 0x9a, (byte) 0x07, (byte) 0x12},

            {(byte) 0x80, (byte) 0xe2, (byte) 0xeb, (byte) 0x27, (byte) 0xb2, (byte) 0x75, (byte) 0x09, (byte) 0x83,
                    (byte) 0x2c, (byte) 0x1a, (byte) 0x1b, (byte) 0x6e, (byte) 0x5a, (byte) 0xa0, (byte) 0x52, (byte) 0x3b},

            {(byte) 0x79, (byte) 0x5b, (byte) 0x77, (byte) 0x6b, (byte) 0x9d, (byte) 0x8d, (byte) 0x53, (byte) 0x76,
                    (byte) 0xb9, (byte) 0x66, (byte) 0x2c, (byte) 0x0b, (byte) 0x85, (byte) 0x19, (byte) 0x11, (byte) 0x4f},

            {(byte) 0x99, (byte) 0x87, (byte) 0x9e, (byte) 0x8f, (byte) 0x9b, (byte) 0x93, (byte) 0x1b, (byte) 0x17,
                    (byte) 0x7d, (byte) 0xb3, (byte) 0xe6, (byte) 0x95, (byte) 0x77, (byte) 0x87, (byte) 0x56, (byte) 0xa0},

            {(byte) 0x63, (byte) 0x51, (byte) 0x2f, (byte) 0x89, (byte) 0x72, (byte) 0x9e, (byte) 0x8c, (byte) 0xa7,
                    (byte) 0x35, (byte) 0xb8, (byte) 0xd2, (byte) 0x8b, (byte) 0x9c, (byte) 0x35, (byte) 0x8b, (byte) 0x87},

            {(byte) 0x2f, (byte) 0x79, (byte) 0x81, (byte) 0xf6, (byte) 0xb4, (byte) 0x17, (byte) 0x2d, (byte) 0x54,
                    (byte) 0x7e, (byte) 0x60, (byte) 0x7f, (byte) 0x62, (byte) 0x69, (byte) 0xa6, (byte) 0x9b, (byte) 0xd4},

            {(byte) 0x4c, (byte) 0x8d, (byte) 0x9e, (byte) 0xd3, (byte) 0xa5, (byte) 0x78, (byte) 0x0d, (byte) 0x85,
                    (byte) 0x91, (byte) 0x58, (byte) 0x3c, (byte) 0x50, (byte) 0x7a, (byte) 0x59, (byte) 0x11, (byte) 0x56},

            {(byte) 0x69, (byte) 0x7f, (byte) 0x7b, (byte) 0x38, (byte) 0xb5, (byte) 0x54, (byte) 0x85, (byte) 0x8c,
                    (byte) 0xd7, (byte) 0xe1, (byte) 0x1c, (byte) 0xa8, (byte) 0x2b, (byte) 0xb8, (byte) 0x80, (byte) 0x61},

            {(byte) 0x49, (byte) 0x46, (byte) 0x06, (byte) 0x5d, (byte) 0x63, (byte) 0x63, (byte) 0x80, (byte) 0x2b,
                    (byte) 0x6b, (byte) 0x3b, (byte) 0x5e, (byte) 0x12, (byte) 0x22, (byte) 0x57, (byte) 0x7a, (byte) 0x62},

            {(byte) 0x24, (byte) 0x2b, (byte) 0x17, (byte) 0x88, (byte) 0x32, (byte) 0x24, (byte) 0x92, (byte) 0xa7,
                    (byte) 0xf2, (byte) 0x5d, (byte) 0x9a, (byte) 0x51, (byte) 0x49, (byte) 0x78, (byte) 0xd0, (byte) 0x4a},

            {(byte) 0x7f, (byte) 0x51, (byte) 0x24, (byte) 0x13, (byte) 0x8b, (byte) 0x4e, (byte) 0x0f, (byte) 0x81,
                    (byte) 0x75, (byte) 0xa6, (byte) 0x94, (byte) 0x6d, (byte) 0x38, (byte) 0x80, (byte) 0xe5, (byte) 0x9d},

            {(byte) 0x77, (byte) 0x8b, (byte) 0xa9, (byte) 0x12, (byte) 0x2b, (byte) 0x9b, (byte) 0x6b, (byte) 0x63,
                    (byte) 0x53, (byte) 0xe4, (byte) 0x97, (byte) 0x99, (byte) 0xc9, (byte) 0x3f, (byte) 0xd1, (byte) 0x10},

            {(byte) 0x57, (byte) 0x95, (byte) 0x4b, (byte) 0x88, (byte) 0x8a, (byte) 0x5d, (byte) 0x28, (byte) 0x65,
                    (byte) 0xd0, (byte) 0x3e, (byte) 0x85, (byte) 0x59, (byte) 0x97, (byte) 0x87, (byte) 0x4b, (byte) 0x9d}
    };


    public static void subBytes(byte[] state){
        for(int i=0;i<state.length;i++){
            state[i] = (byte) S_BOX[state[i] & 0xFF];
        }
    }
//public static shiftRow function
//public static MixColumn function
    public static void main(String[] args) {



    }
}