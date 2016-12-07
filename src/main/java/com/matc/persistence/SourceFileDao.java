package com.matc.persistence;

import com.matc.entity.SourceFile;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.annotations.Source;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by student on 12/7/16.
 */
public class SourceFileDao extends GenericDao{

    /**
     * Returns a file based selected file name
     * @param fileName  the file name
     * @return          file
     */
    public SourceFile getFileByName(String fileName) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        List<SourceFile> files = session.createCriteria(SourceFile.class)
                    .add(Restrictions.eq("fileName", fileName))
                    .list();
        SourceFile sourceFile = null;

        if (files.size() > 0) {
            sourceFile = files.get(0);
        }

        session.close();
        return sourceFile;
    }

    /**
     * Returns files by type
     * @param type  the type of file
     * @return      list of files
     */
    public List<SourceFile> getFilesByType(String type) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        List<SourceFile> sourceFiles = session.createCriteria(SourceFile.class)
                    .add(Restrictions.eq("fileType", type))
                    .list();

        return sourceFiles;
    }
}
