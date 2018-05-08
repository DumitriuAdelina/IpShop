package recommender;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.impl.recommender.CachingRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;

public class Recommender {
	
	public List<Long> recommendTraining(){
        List<Long> list = null;
        try {
            list = new ArrayList<>();
            
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://localhost:3306/proiectip");
            dataSource.setUsername("pip");
            dataSource.setPassword("qwerty");
            
            DataModel model = new MySQLJDBCDataModel(dataSource,"note","id_user",
                    "id_produs","nota",null);
//            ItemSimilarity similarity = new PearsonCorrelationSimilarity(model);
            ItemSimilarity similarity = new LogLikelihoodSimilarity(model);
            GenericItemBasedRecommender recommender = new GenericItemBasedRecommender(model, similarity);
            CachingRecommender recommender1 = new CachingRecommender(recommender);
            List<RecommendedItem> recommendedItemList = recommender1.recommend(2,2);
            for(RecommendedItem i : recommendedItemList)
            { 
            	list.add(i.getItemID());
                //System.out.println(i.getValue());
            }
            
        } catch (TasteException e) {
            e.printStackTrace();
        }
        return list;
    }
}
