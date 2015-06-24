package com.sydads.data.jpa;

import org.hibernate.cfg.Configuration;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.DefaultPersistenceUnitManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.spi.PersistenceProvider;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: neilmao
 * Date: 20/04/15
 */
public class JpaSchemaExport {

    private static final String SQL_CREATE_FILE = "schema-create.sql";

    @Autowired
    private LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean;

    public static void main(String[] args) throws IOException {
        new JpaSchemaExport().execute();
        System.exit(0);
    }

    public void execute() {

        PersistenceProvider persistenceProvider = new HibernatePersistenceProvider();

        EntityManagerFactory entityManagerFactory = persistenceProvider.createContainerEntityManagerFactory(
                localContainerEntityManagerFactoryBean.getPersistenceUnitInfo(),
                localContainerEntityManagerFactoryBean.getJpaPropertyMap());

        org.hibernate.tool.hbm2ddl.SchemaExport schemaExport = new org.hibernate.tool.hbm2ddl.SchemaExport(
                configured.getHibernateConfiguration());
//        if(getDestination() == null) {
//            setDestination(getClass().getResource("/").getFile() + "schema-export.sql");
//        }
//        schemaExport.setOutputFile(getDestination());
//        schemaExport.setFormat(isFormat());
//        schemaExport.execute(true, false, false, isCreate());
    }

//    public static void execute(String persistenceUnitName, String destination) {
//
//        Path currentRelativePath = Paths.get("");
//        String path = currentRelativePath.toAbsolutePath().toString();
//
//        System.out.println("Generating DDL create script to : " + path + "/" + destination);
//
//        final Properties properties = new Properties();
//
//        //  force persistence properties : remove database target
//        properties.setProperty(org.hibernate.cfg.AvailableSettings.HBM2DDL_AUTO, "");
//        properties.setProperty(org.hibernate.jpa.AvailableSettings.SCHEMA_GEN_DATABASE_ACTION, "create");
//
//        // force persistence properties : define create script target from metadata to destination
//        properties.setProperty(org.hibernate.jpa.AvailableSettings.SCHEMA_GEN_CREATE_SCHEMAS, "true");
//        properties.setProperty(org.hibernate.jpa.AvailableSettings.SCHEMA_GEN_SCRIPTS_ACTION, "create");
//        properties.setProperty(org.hibernate.jpa.AvailableSettings.SCHEMA_GEN_CREATE_SOURCE, "metadata");
//        properties.setProperty(org.hibernate.jpa.AvailableSettings.SCHEMA_GEN_SCRIPTS_CREATE_TARGET,
//                               destination + SQL_CREATE_FILE);
//
//        Persistence.generateSchema(persistenceUnitName, properties);
//    }
}
