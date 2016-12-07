package com.matc.persistence;

import com.matc.entity.SourceFile;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by student on 12/7/16.
 */
public class SourceFileDaoTest {

    private SourceFile sourceFile;
    private Logger log = Logger.getLogger(this.getClass());

    @Before
    public void setup() {
        sourceFile = new SourceFile("Car", "public class Car { public Car() {} }", "js");
    }

    @Test
    public void create() {
        SourceFileDao sourceFileDao = new SourceFileDao();
        assertTrue(sourceFileDao.create(sourceFile) > -1);

        sourceFileDao.delete(sourceFile);
    }

    @Test
    public void getFileByName() throws Exception {
        SourceFileDao sourceFileDao = new SourceFileDao();
        assertNotNull("No such file", sourceFileDao.getFileByName("Analyzer"));
    }

    @Test
    public void getFilesByType() throws Exception {
        SourceFileDao sourceFileDao = new SourceFileDao();
        assertTrue(sourceFileDao.getFilesByType("js").size() > 0);
    }
}