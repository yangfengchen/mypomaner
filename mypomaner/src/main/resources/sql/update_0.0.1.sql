ALTER TABLE TBL_PROJECT_CONFIG ADD COLUMN FILE_NAME_CONVERT int;

update TBL_PROJECT_CONFIG set FILE_NAME_CONVERT = 1;

ALTER TABLE TBL_PROJECT_TABLE ADD COLUMN FILE_NAME_CONVERT int;

update TBL_PROJECT_TABLE set FILE_NAME_CONVERT = 1;