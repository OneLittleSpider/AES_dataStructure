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

    public static void addRoundKey(byte[] plainText, byte[] key){
        for(int i=0;i< plainText.length;i++){
            plainText[i]^=key[i];
        }
    }
//public static subBytes function
//public static shiftRow function
//public static MixColumn function
    public static void main(String[] args) {



    }
}