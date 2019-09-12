package eu.elixir.ega.ebi.reencryption.dao;

import java.util.List;

import eu.elixir.ega.ebi.reencryption.beans.Processed_files;

public interface ReencDao {
    
    String update(Processed_files processfiles);
    List<Processed_files> getAllFiles();
    Processed_files search(String fileid);

}
