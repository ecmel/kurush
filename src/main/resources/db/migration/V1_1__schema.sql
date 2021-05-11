CREATE EXTENSION IF NOT EXISTS LTREE;

CREATE TABLE journal (
    id uuid PRIMARY KEY NOT NULL,
    name text NOT NULL
);

CREATE TABLE account (
    id uuid PRIMARY KEY NOT NULL,
    journal_id uuid NOT NULL,
    code ltree NOT NULL,
    name text NOT NULL,
    CONSTRAINT account_fkey_journal FOREIGN KEY (journal_id) REFERENCES journal (id)
);

CREATE INDEX account_idx_code ON account USING GIST (code);

CREATE UNIQUE INDEX account_idx_code_uni ON account (code);

CREATE TABLE transfer (
    id uuid PRIMARY KEY NOT NULL,
    journal_id uuid NOT NULL,
    date date NOT NULL,
    CONSTRAINT transfer_fkey_journal FOREIGN KEY (journal_id) REFERENCES journal (id)
);

CREATE TABLE entry (
    id uuid PRIMARY KEY NOT NULL,
    transfer_id uuid NOT NULL,
    account_id uuid NOT NULL,
    amount numeric NOT NULL,
    debit numeric NOT NULL,
    credit numeric NOT NULL,
    CONSTRAINT entry_fkey_transfer FOREIGN KEY (transfer_id) REFERENCES transfer (id),
    CONSTRAINT entry_fkey_account FOREIGN KEY (account_id) REFERENCES account (id)
);

