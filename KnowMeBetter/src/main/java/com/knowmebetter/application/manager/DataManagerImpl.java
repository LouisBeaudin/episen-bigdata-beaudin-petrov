package com.knowmebetter.application.manager;
import com.knowmebetter.business.dao.*;
import com.knowmebetter.business.model.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.poi.ss.util.CellUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataManagerImpl implements DataManager{

    public static final String SAMPLE_XLSX_FILE_PATH = "./auteurs1.xlsx";
    public static final String SAMPLE_XLSX_FILE_PATH_2 = "./auteurs2.xlsx";
    public static final String SAMPLE_XLSX_FILE_PATH_3 = "./auteurs3.xlsx";
    public static final String SAMPLE_XLSX_FILE_PATH_4 = "./auteurs4.xlsx";
    public static final String SAMPLE_XLSX_FILE_PATH_5 = "./auteurs5.xlsx";

    @Autowired
    AuthorDAO authorDAO;

    @Autowired
    JointureDAO jointureDAO;

    @Autowired
    AuthorDAO2 authorDAO2;

    @Autowired
    JointureDAO2 jointureDAO2;

    @Autowired
    AuthorDAO3 authorDAO3;

    @Autowired
    JointureDAO3 jointureDAO3;

    @Autowired
    AuthorDAO4 authorDAO4;

    @Autowired
    JointureDAO4 jointureDAO4;

    @Autowired
    AuthorDAO5 authorDAO5;

    @Autowired
    JointureDAO5 jointureDAO5;

    @Override
    public void formatdata() throws IOException, InvalidFormatException {
        Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH_5));
        Sheet sheet = workbook.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();
        for (Row row: sheet) {
            for(Cell cell: row) {

                String cellValue = dataFormatter.formatCellValue(cell);
                String split[] = cellValue.split(";", 10);
                for(String s:split) {
                    List<Author5> allAuthors = authorDAO5.findAll();
                    s = s.replaceAll("\\s", "");
                    System.out.println(s);
                    boolean add = true;
                    for(Author5 author: allAuthors){
                        if(author.getName().equals(s)){
                            add = false;
                        }
                    }
                    if (add){
                        Author5 authorToSave = new Author5(s);
                        authorDAO5.save(authorToSave);
                    }
                }
            }
            System.out.println();
        }
    }

    @Override
    public void jointure() throws IOException, InvalidFormatException {
        Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH_5));
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
                    Author5 authorSource = authorDAO5.findByName(nameAuthor);
                    int compteur = i;
                    while(compteur+1<allAuthors.size()){
                        nameAuthor = allAuthors.get(compteur+1);
                        Author5 authorTarget = authorDAO5.findByName(nameAuthor);
                        Jointure5 jointure = new Jointure5(authorSource.getId(), authorTarget.getId());
                        jointureDAO5.save(jointure);
                        compteur++;
                    }
                }
            }
            System.out.println();
        }
    }

    @Override
    public void top() throws IOException, InvalidFormatException {
        List<Jointure> jointures = jointureDAO.findAll();
        boolean ASC = true;
        //Premier id de l'auteur et deuxieme count
        ConcurrentHashMap<Long, Integer> classementAuteurs = new ConcurrentHashMap<Long, Integer>();

        for(Jointure jointure: jointures){
            if(classementAuteurs.size() == 0){
                classementAuteurs.put(jointure.getTarget(),  1);
                classementAuteurs.put(jointure.getSource(),  1);
            } else {
                for (Long auteurs : classementAuteurs.keySet()) {

                    if(auteurs.equals(jointure.getTarget())){
                        classementAuteurs.put(auteurs,  classementAuteurs.get(auteurs) + 1);
                    } else {
                        classementAuteurs.put(jointure.getTarget(),  1);
                    }

                    if(auteurs.equals(jointure.getSource())){
                        classementAuteurs.put(auteurs,  classementAuteurs.get(auteurs) + 1);
                    } else {
                        classementAuteurs.put(jointure.getSource(),  1);
                    }
                }
            }
        }
        Map<Long, Integer> sortedMapAsc = sortByComparator(classementAuteurs, ASC);
        printMap(sortedMapAsc);



    }

    private static Map<Long, Integer> sortByComparator(Map<Long, Integer> unsortMap, final boolean order)
    {
        List<Map.Entry<Long, Integer>> list = new LinkedList<Map.Entry<Long, Integer>>(unsortMap.entrySet());
        // Sorting the list based on values
        Collections.sort(list, new Comparator<Map.Entry<Long, Integer>>()
        {
            public int compare(Map.Entry<Long, Integer> o1,
                               Map.Entry<Long, Integer> o2)
            {
                if (order)
                {
                    return o1.getValue().compareTo(o2.getValue());
                }
                else
                {
                    return o2.getValue().compareTo(o1.getValue());

                }
            }
        });

        // Maintaining insertion order with the help of LinkedList
        Map<Long, Integer> sortedMap = new LinkedHashMap<Long, Integer>();
        for (Map.Entry<Long, Integer> entry : list)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    public static void printMap(Map<Long, Integer> map)
    {
        for (Map.Entry<Long     , Integer> entry : map.entrySet())
        {
            System.out.println("Key : " + entry.getKey() + " Value : "+ entry.getValue());
        }
    }

}
