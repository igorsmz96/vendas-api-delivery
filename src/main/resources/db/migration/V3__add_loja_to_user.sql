ALTER TABLE tb_user
    ADD COLUMN store_id BIGINT;

ALTER TABLE tb_user
    ADD CONSTRAINT fk_user_store
        FOREIGN KEY (store_id) REFERENCES tb_store(id);