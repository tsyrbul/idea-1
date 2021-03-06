package ua.pp.idea.dao;


import org.springframework.stereotype.Repository;
import ua.pp.idea.dao.crud.DeleteIdeaByID;
import ua.pp.idea.dao.crud.InsertNewIdea;
import ua.pp.idea.dao.crud.SelectAllIdea;
import ua.pp.idea.dao.crud.SelectIdeaById;
import ua.pp.idea.entity.Idea;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dark on 07.11.2016.
 */
@Repository
public class IdeaDaoImpl implements Serializable,IdeaDao{
    private DataSource dataSource;
    private SelectAllIdea selectAllIdea;
    private SelectIdeaById selectIdeaById;
    private InsertNewIdea insertNewIdea;
    private DeleteIdeaByID deleteIdeaByID;


    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.selectAllIdea = new SelectAllIdea(dataSource);
        this.selectIdeaById = new SelectIdeaById(dataSource);
        this.insertNewIdea = new InsertNewIdea(dataSource);
        this.deleteIdeaByID = new DeleteIdeaByID(dataSource);
    }

    public List<Idea> getAll() {

        return selectAllIdea.execute();
    }

    public Idea findIdeaByID(int id) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", id);
        try {
            return selectIdeaById.executeByNamedParam(paramMap).get(0);
        } catch (Exception e) {
            Idea i1 = new Idea();
            i1.setId(0);
            i1.setCaption("Данных нет");
            i1.setTxt("Идея не существует");
            return i1;

        }


    }

    public void createIdea(Idea idea) {
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("txt",idea.getTxt());
        paramMap.put("pict",idea.getPict());
        paramMap.put("video",idea.getVideo());
        paramMap.put("caption",idea.getCaption());
        paramMap.put("category",idea.getCategory());
        paramMap.put("tags",idea.getTags());
        paramMap.put("username",idea.getUsername());
        insertNewIdea.updateByNamedParam(paramMap);


    }

    public void deleteIdeaById(Idea idea){
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("id",idea.getId());
        deleteIdeaByID.updateByNamedParam(paramMap);
    }

}
