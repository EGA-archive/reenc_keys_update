# Description

The `re_encryption schema` has keys as plain text. This programme encrypts that plain keys text and store into the `enc_key` column in `processed_files` table.

# How to run 

Run the main class is `eu.elixir.ega.ebi.reencryption.main.Main`. It will get all the files which has null enc_key and update it with encrypted keys.

# Note
Before running the Main class update the `src/main/resources/applicationContext.xml` datasource url, datasource username, datasource password & passwordEncryptKey. The value of passwordEncryptKey is same value as `ega.key.dbPasswordDecryptKey` in config file of `ega-data-api` key service.

 