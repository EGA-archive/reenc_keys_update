package eu.elixir.ega.ebi.reencryption.main;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import eu.elixir.ega.ebi.reencryption.beans.Processed_files;
import eu.elixir.ega.ebi.reencryption.dao.ReencDao;

public class Main {

    private static String passwordEncryptKey;

    public static void main(String[] args) throws IOException, InterruptedException {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ReencDao reencDao = (ReencDao) context.getBean("reencDao");

        List<Processed_files> pfs = reencDao.getAllFiles();
        System.out.println(pfs.size());

        for (Processed_files pf : pfs) {
            final char[] password = passwordEncryptKey.toCharArray();
            String dbstorekey_encrypted = new String(Base64.getEncoder().encode(doEncrypt(pf.getKey().getBytes(), password)));

            // updating keys
            pf.setEnc_key(dbstorekey_encrypted);
            String status = reencDao.update(pf);

            if (!status.equals("success")) {
                System.out.println("update failure " + pf.getFile_id());
            }
        }

    }

    public static byte[] doEncrypt(byte[] data, char[] password) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        OutputStream stream = new AesCtr256Ega().encrypt(password, baos);
        stream.write(data);
        byte[] encryptedData = baos.toByteArray();
        return encryptedData;
    }

    public String getPasswordEncryptKey() {
        return passwordEncryptKey;
    }

    public void setPasswordEncryptKey(String passwordEncryptKey) {
        this.passwordEncryptKey = passwordEncryptKey;
    }

}
