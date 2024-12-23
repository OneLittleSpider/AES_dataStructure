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
            // the xor operation above
        }
    }

    private static final byte[][] S_BOX = {
            {(byte)0x63, (byte)0x7C, (byte)0x77, (byte)0x7B, (byte)0xF2, (byte)0x6B, (byte)0x6F, (byte)0xC5, (byte)0x30, (byte)0x01, (byte)0x67, (byte)0x2B, (byte)0xFE, (byte)0xD7, (byte)0xAB, (byte)0x76},
            {(byte)0xCA, (byte)0x82, (byte)0xC9, (byte)0x7D, (byte)0xFA, (byte)0x59, (byte)0x47, (byte)0xF0, (byte)0xAD, (byte)0xD4, (byte)0xA2, (byte)0xAF, (byte)0x9C, (byte)0xA4, (byte)0x72, (byte)0xC0},
            {(byte)0xB7, (byte)0xFD, (byte)0x93, (byte)0x26, (byte)0x36, (byte)0x3F, (byte)0xF7, (byte)0xCC, (byte)0x34, (byte)0xA5, (byte)0xE5, (byte)0xF1, (byte)0x71, (byte)0xD8, (byte)0x31, (byte)0x15},
            {(byte)0x04, (byte)0xC7, (byte)0x23, (byte)0xC3, (byte)0x18, (byte)0x96, (byte)0x05, (byte)0x9A, (byte)0x07, (byte)0x12, (byte)0x80, (byte)0xE2, (byte)0xEB, (byte)0x27, (byte)0xB2, (byte)0x75},
            {(byte)0x09, (byte)0x83, (byte)0x2C, (byte)0x1A, (byte)0x1B, (byte)0x6E, (byte)0x5A, (byte)0xA0, (byte)0x52, (byte)0x3B, (byte)0xD6, (byte)0xB3, (byte)0x29, (byte)0xE3, (byte)0x2F, (byte)0x84},
            {(byte)0x53, (byte)0xD1, (byte)0x00, (byte)0xED, (byte)0x20, (byte)0xFC, (byte)0xB1, (byte)0x5B, (byte)0x6A, (byte)0xCB, (byte)0xBE, (byte)0x39, (byte)0x4A, (byte)0x4C, (byte)0x58, (byte)0xCF},
            {(byte)0xD0, (byte)0xEF, (byte)0xAA, (byte)0xFB, (byte)0x43, (byte)0x4D, (byte)0x33, (byte)0x85, (byte)0x45, (byte)0xF9, (byte)0x02, (byte)0x7F, (byte)0x50, (byte)0x3C, (byte)0x9F, (byte)0xA8},
            {(byte)0x51, (byte)0xA3, (byte)0x40, (byte)0x8F, (byte)0x92, (byte)0x9D, (byte)0x38, (byte)0xF5, (byte)0xBC, (byte)0xB6, (byte)0xDA, (byte)0x21, (byte)0x10, (byte)0xFF, (byte)0xF3, (byte)0xD2},
            {(byte)0xCD, (byte)0x0C, (byte)0x13, (byte)0xEC, (byte)0x5F, (byte)0x97, (byte)0x44, (byte)0x17, (byte)0xC4, (byte)0xA7, (byte)0x7E, (byte)0x3D, (byte)0x64, (byte)0x5D, (byte)0x19, (byte)0x73},
            {(byte)0x60, (byte)0x81, (byte)0x4F, (byte)0xDC, (byte)0x22, (byte)0x2A, (byte)0x90, (byte)0x88, (byte)0x46, (byte)0xEE, (byte)0xB8, (byte)0x14, (byte)0xDE, (byte)0x5E, (byte)0x0B, (byte)0xDB},
            {(byte)0xE0, (byte)0x32, (byte)0x3A, (byte)0x0A, (byte)0x49, (byte)0x06, (byte)0x24, (byte)0x5C, (byte)0xC2, (byte)0xD3, (byte)0xAC, (byte)0x62, (byte)0x91, (byte)0x95, (byte)0xE4, (byte)0x79},
            {(byte)0xE7, (byte)0xC8, (byte)0x37, (byte)0x6D, (byte)0x8D, (byte)0xD5, (byte)0x4E, (byte)0xA9, (byte)0x6C, (byte)0x56, (byte)0xF4, (byte)0xEA, (byte)0x65, (byte)0x7A, (byte)0xAE, (byte)0x08},
            {(byte)0xBA, (byte)0x78, (byte)0x25, (byte)0x2E, (byte)0x1C, (byte)0xA6, (byte)0xB4, (byte)0xC6, (byte)0xE8, (byte)0xDD, (byte)0x74, (byte)0x1F, (byte)0x4B, (byte)0xBD, (byte)0x8B, (byte)0x8A},
            {(byte)0x70, (byte)0x3E, (byte)0xB5, (byte)0x66, (byte)0x48, (byte)0x03, (byte)0xF6, (byte)0x0E, (byte)0x61, (byte)0x35, (byte)0x57, (byte)0xB9, (byte)0x86, (byte)0xC1, (byte)0x1D, (byte)0x9E},
            {(byte)0xE1, (byte)0xF8, (byte)0x98, (byte)0x11, (byte)0x69, (byte)0xD9, (byte)0x8E, (byte)0x94, (byte)0x9B, (byte)0x1E, (byte)0x87, (byte)0xE9, (byte)0xCE, (byte)0x55, (byte)0x28, (byte)0xDF},
            {(byte)0x8C, (byte)0xA1, (byte)0x89, (byte)0x0D, (byte)0xBF, (byte)0xE6, (byte)0x42, (byte)0x68, (byte)0x41, (byte)0x99, (byte)0x2D, (byte)0x0F, (byte)0xB0, (byte)0x54, (byte)0xBB, (byte)0x16}
    };

    
    public static void subBytes(byte[] state){
        for(int i=0;i<state.length;i++){
            int row = (state[i] >> 4) & 0x0F; //get the row # from high nibble
            int col = state[i] & 0x0F; //get the col # from low nibble
//            System.out.println("i= "+i);
//            System.out.println("row= "+row);
//            System.out.println("col= "+col);
            state[i] = S_BOX[row][col];
        }
    }

    public static void shiftRow(byte[] state){
        byte[] temp = new byte[16];

        // row 1 stay the same (no shift)
        temp[0] = state[0];
        temp[4] = state[4];
        temp[8] = state[8];
        temp[12] = state[12];

        //shift every element in row 2 by 1
        temp[1]=state[5];
        temp[5]=state[9];
        temp[9]=state[13];
        temp[13]=state[1];


        //shift every element in row 3 by 2
        temp[2]=state[10];
        temp[6]=state[14];
        temp[10]=state[2];
        temp[14]=state[6];

        //shift every element in row 3 by 3
        temp[3]=state[15];
        temp[7]=state[3];
        temp[11]=state[7];
        temp[15]=state[11];

        for(int i=0;i<state.length;i++){
            state[i]=temp[i];
        }
    }

    //I did not write the code below. The MixColumn work is taken from the link below with some changes made.
    // code reference: https://www.tutorialspoint.com/cryptography/cryptography_mixcolumns_transformation.htm
    public static void mixColumns(byte[] state) {
        for (int i = 0; i < 4; i++) {
            // Get each column
            byte a = state[i * 4];
            byte b = state[i * 4 + 1];
            byte c = state[i * 4 + 2];
            byte d = state[i * 4 + 3];

            // Perform the MixColumns transformation for the column
            state[i * 4] = (byte) (mulBy2(a) ^ mulBy3(b) ^ c ^ d);
            state[i * 4 + 1] = (byte) (a ^ mulBy2(b) ^ mulBy3(c) ^ d);
            state[i * 4 + 2] = (byte) (a ^ b ^ mulBy2(c) ^ mulBy3(d));
            state[i * 4 + 3] = (byte) (mulBy3(a) ^ b ^ c ^ mulBy2(d));
        }
    }

    // Multiply byte by 2 in GF(2^8)
    public static byte mulBy2(byte b) {
        if ((b & 0x80) != 0) {
            return (byte) ((b << 1) ^ 0x1B);  // Polynomial 0x1B for AES
        } else {
            return (byte) (b << 1);
        }
    }

    // Multiply byte by 3 in GF(2^8)
    public static byte mulBy3(byte b) {
        return (byte) (mulBy2(b) ^ b);
    }





    public static void printState(byte[] state) {
        System.out.print("[ ");
        for (byte b : state) {
            System.out.printf("0x%02x ", b);  // Print each byte in hexadecimal format
        }
        System.out.println("]");
    }



    //public static MixColumn function
    public static void main(String[] args) {

        try {
            // Generate secret key and IV
            SecretKey secretKey = keyGenerator();
            IvParameterSpec iv = ivGenerator();

            // Sample input data (16 bytes block)
            byte[] plaintext = new byte[16];
            for (int i = 0; i < 16; i++) {
                plaintext[i] = (byte) (i + 1); // Just some example data
            }

            // Print the original state (plaintext)
            System.out.print("Original State: ");
            printState(plaintext);

            // Apply addRoundKey
            byte[] key = secretKey.getEncoded();
            addRoundKey(plaintext, key);

            System.out.print("key is: ");
            printState(key);

            // Print state after addRoundKey
            System.out.print("After addRoundKey: ");
            printState(plaintext);

            // Apply SubBytes transformation
            subBytes(plaintext);

            // Print state after SubBytes
            System.out.print("After SubBytes: ");
            printState(plaintext);

            // Apply shiftRow transformation
            shiftRow(plaintext);

            // Print state after shiftRow
            System.out.print("After ShiftRow: ");
            printState(plaintext);


            // Apply MixCOlumn transformation
            mixColumns(plaintext);

            // Print state after MixColumn
            System.out.print("After MixColumn: ");
            printState(plaintext);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

}
