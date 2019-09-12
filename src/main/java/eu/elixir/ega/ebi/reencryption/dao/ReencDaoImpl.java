package eu.elixir.ega.ebi.reencryption.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import eu.elixir.ega.ebi.reencryption.beans.Processed_files;
import eu.elixir.ega.ebi.reencryption.mapper.ProcessedfilesRowMapper;

public class ReencDaoImpl implements ReencDao {

    private String status = "failure";
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String update(Processed_files processfiles) {
        int rowcount = 0;
        try {
            rowcount = jdbcTemplate.update("update processed_files set enc_key='" + processfiles.getEnc_key()
                    + "' where file_id='" + processfiles.getFile_id() + "'");
            if (rowcount == 1) {
                status = "success";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public List<Processed_files> getAllFiles() {
        List<Processed_files> pf = null;
        try {
            pf = jdbcTemplate.query("select file_id, key, enc_key from processed_files", new ProcessedfilesRowMapper());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pf;
    }


    @Override
    public Processed_files search(String fileid) {
        Processed_files pf = null;
        try {
            pf = jdbcTemplate.queryForObject("select * from processed_files where file_id='" + fileid+"'" , new ProcessedfilesRowMapper());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pf;
    }
}
