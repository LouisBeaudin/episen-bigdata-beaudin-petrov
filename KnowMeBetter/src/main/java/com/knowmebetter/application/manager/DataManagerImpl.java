package com.knowmebetter.application.manager;
import com.knowmebetter.business.dao.AuthorDAO;
import com.knowmebetter.business.dao.JointureDAO;
import com.knowmebetter.business.model.Author;
import com.knowmebetter.business.model.Jointure;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataManagerImpl implements DataManager{

    public static final String SAMPLE_XLSX_FILE_PATH = "./auteurs.xlsx";

    @Autowired
    AuthorDAO authorDAO;

    @Autowired
    JointureDAO jointureDAO;

    @Override
    public void formatdata() throws IOException, InvalidFormatException {
        Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));
        Sheet sheet = workbook.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();
        for (Row row: sheet) {
            for(Cell cell: row) {

                String cellValue = dataFormatter.formatCellValue(cell);
                String split[] = cellValue.split(";", 10);
                for(String s:split) {
                    List<Author> allAuthors = authorDAO.findAll();
                    s = s.replaceAll("\\s", "");
                    System.out.println(s);
                    boolean add = true;
                    for(Author author: allAuthors){
                        if(author.getName().equals(s)){
                            add = false;
                        }
                    }
                    if (add){
                        Author authorToSave = new Author(s);
                        authorDAO.save(authorToSave);
                    }
                }
            }
            System.out.println();
        }
    }

    @Override
    public void jointure() throws IOException, InvalidFormatException {
        Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));
        Sheet sheet = workbook.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();
        for (Row row: sheet) {
            for(Cell cell: row) {

                String cellValue = dataFormatter.formatCellValue(cell);
                String split[] = cellValue.split(";", 10);
                List<String> allAuthors = new ArrayList<>();
                for(String s:split) {
                    s = s.replaceAll("\\s", "");
                    allAuthors.add(s);

                }
                for (int i=0; i<allAuthors.size(); i++){
                    String nameAuthor;
                    nameAuthor = allAuthors.get(i);
                    Author authorSource = authorDAO.findByName(nameAuthor);
                    int compteur = i;
                    while(compteur+1<allAuthors.size()){
                        nameAuthor = allAuthors.get(compteur+1);
                        Author authorTarget = authorDAO.findByName(nameAuthor);
                        Jointure jointure = new Jointure(authorSource.getId(), authorTarget.getId());
                        jointureDAO.save(jointure);
                        compteur++;
                    }
                }
            }
            System.out.println();
        }
    }
}
