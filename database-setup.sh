{
  echo "mysqlJDBCDriver=com.mysql.cj.jdbc.Driver"
  echo "databaseType=production"
  echo "databaseURL=$PROD_DATABASE_URL"
  echo "productionDatabase=$PROD_DATABASE"
  echo "productionUsername=$PROD_DATABASE_USERNAME"
  echo "productionPassword=$PROD_DATABASE_PASSWORD"
} >> databaseConfig.properties

ssh -o StrictHostKeyChecking=no ${PROD_USER}@${PROD_HOST} "mkdir ${PROD_DIR}/${CI_COMMIT_REF_NAME}_${CI_COMMIT_SHORT_SHA}"
scp -r -o StrictHostKeyChecking=no $TARGET_FOLDER_NAME/$GENERATED_JAR_FILE_NAME "${PROD_USER}@${PROD_HOST}:${PROD_DIR}/${CI_COMMIT_REF_NAME}_${CI_COMMIT_SHORT_SHA}/$GENERATED_JAR_FILE_NAME"
scp -r -o StrictHostKeyChecking=no databaseConfig.properties "${PROD_USER}@${PROD_HOST}:${PROD_DIR}/${CI_COMMIT_REF_NAME}_${CI_COMMIT_SHORT_SHA}/databaseConfig.properties"