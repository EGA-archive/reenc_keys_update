package eu.elixir.ega.ebi.reencryption.beans;

public class Processed_files {
    
    String file_id;
    String key;
    String enc_key;
    
    public Processed_files(String file_id, String key, String enc_key) {
        super();
        this.file_id = file_id;
        this.key = key;
        this.enc_key = enc_key;
    }
    
    public Processed_files() {
    }
    
    public String getFile_id() {
        return file_id;
    }
    public void setFile_id(String file_id) {
        this.file_id = file_id;
    }
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }

    public String getEnc_key() {
        return enc_key;
    }

    public void setEnc_key(String enc_key) {
        this.enc_key = enc_key;
    }

    @Override
    public String toString() {
        return "Processed_files [file_id=" + file_id + ", key=" + key + ", enc_key=" + enc_key + "]";
    }
    
}
