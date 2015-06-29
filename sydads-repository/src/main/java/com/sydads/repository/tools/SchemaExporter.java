package com.sydads.repository.tools;

import com.sydads.repository.config.DataConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManagerFactory;
import javax.persistence.metamodel.ManagedType;
import javax.persistence.spi.PersistenceProvider;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: neilmao
 * Date: 20/04/15
 */
public class SchemaExporter {

    private final static Log LOG = LogFactory.getLog(SchemaExporter.class);

    private final String sqlFile = "src/main/resources/schema.sql";

    public static void main(String[] args) throws IOException {
        new SchemaExporter().execute();
        System.exit(0);
    }

    public void execute() {

        DataConfig dataConfig = new DataConfig();

        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = dataConfig.entityManagerFactory();

        PersistenceProvider persistenceProvider = new HibernatePersistenceProvider();

        EntityManagerFactory entityManagerFactory = persistenceProvider.createContainerEntityManagerFactory(
                localContainerEntityManagerFactoryBean.getPersistenceUnitInfo(),
                localContainerEntityManagerFactoryBean.getJpaPropertyMap());

        Configuration configuration = new Configuration();

        configuration.addProperties(dataConfig.getHibernateProperties());

        Set<ManagedType<?>> managedTypeSet = entityManagerFactory.getMetamodel().getManagedTypes();

        for (ManagedType<?> managedType : managedTypeSet) {
            configuration.addAnnotatedClass(managedType.getJavaType());
        }

        SchemaExport schemaExport = new SchemaExport(configuration);

        Path currentRelativePath = Paths.get("");
        String path = currentRelativePath.toAbsolutePath().toString();

        schemaExport.setOutputFile(path + "/" + sqlFile);
        LOG.info("Generating DDL create script to : " + path + "/" + sqlFile);
        schemaExport.execute(true, false, false, true);
    }
}
