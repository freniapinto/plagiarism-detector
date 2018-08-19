package edu.neu.msd.plagiarismdetector.ast.comprison;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import edu.neu.msd.plagiarismdetector.utilities.Constants;
import edu.neu.msd.plagiarismdetector.utilities.Constants.COMPARISON_STRATEGIES;

/**
 * Class that computes the weighted score of all the comparison strategies being
 * used
 * 
 * @author vaibhavshukla
 *
 */
public class WeightedScore {

	Map<Constants.COMPARISON_STRATEGIES, Float> comparisonResults;
	List<Constants.COMPARISON_STRATEGIES> mComparisonStrategies = new ArrayList<>();

	public WeightedScore(Map<COMPARISON_STRATEGIES, Float> comparisonResults, List<Constants.COMPARISON_STRATEGIES> mComparisonStrategies) {
		super();
		this.comparisonResults = comparisonResults;
		this.mComparisonStrategies = mComparisonStrategies;
	}
	
	/**
	 * computes the weighted score of all the comparison strategies being
	 * 
	 * @param comparisonResults
	 * @return
	 */

	public float compute(Map<Constants.COMPARISON_STRATEGIES, Float> comparisonResults) {
		Map<Constants.COMPARISON_STRATEGIES, Float> weights = mossLearnIndividiualWeights();
		float score = 0;
		if(mComparisonStrategies.contains(Constants.COMPARISON_STRATEGIES.STRATEGY_EDIT_DISTANCE))
			score += weights.get(Constants.COMPARISON_STRATEGIES.STRATEGY_EDIT_DISTANCE) * comparisonResults.get(Constants.COMPARISON_STRATEGIES.STRATEGY_EDIT_DISTANCE);	
		if(mComparisonStrategies.contains(Constants.COMPARISON_STRATEGIES.STRATEGY_LCS))	
				score += weights.get(Constants.COMPARISON_STRATEGIES.STRATEGY_LCS) * comparisonResults.get(Constants.COMPARISON_STRATEGIES.STRATEGY_LCS);
		if(mComparisonStrategies.contains(Constants.COMPARISON_STRATEGIES.STRATEGY_COSINE_SIMILARITY))
				score += weights.get(Constants.COMPARISON_STRATEGIES.STRATEGY_COSINE_SIMILARITY) * comparisonResults.get(Constants.COMPARISON_STRATEGIES.STRATEGY_COSINE_SIMILARITY);
		return score;

	}
	
	/**
	 * Method to learn weights from MOSS
	 * 
	 * @return
	 */
	public Map<Constants.COMPARISON_STRATEGIES, Float> mossLearnIndividiualWeights()
	{
		Map<Constants.COMPARISON_STRATEGIES, Float> weights =new EnumMap<>(Constants.COMPARISON_STRATEGIES.class);
	
		if(mComparisonStrategies.contains(Constants.COMPARISON_STRATEGIES.STRATEGY_EDIT_DISTANCE))
		{
			if(mComparisonStrategies.size()>1)
			weights.put(Constants.COMPARISON_STRATEGIES.STRATEGY_EDIT_DISTANCE, 0.24f);
			else
				weights.put(Constants.COMPARISON_STRATEGIES.STRATEGY_EDIT_DISTANCE, 1f);	
		}
		if(mComparisonStrategies.contains(Constants.COMPARISON_STRATEGIES.STRATEGY_LCS))
		{
			if(mComparisonStrategies.size()>1)
			weights.put(Constants.COMPARISON_STRATEGIES.STRATEGY_LCS, 0.34f);
			else
				weights.put(Constants.COMPARISON_STRATEGIES.STRATEGY_LCS, 1f);	
		}
		if(mComparisonStrategies.contains(Constants.COMPARISON_STRATEGIES.STRATEGY_COSINE_SIMILARITY))
		{
			if(mComparisonStrategies.size()>1)
			weights.put(Constants.COMPARISON_STRATEGIES.STRATEGY_COSINE_SIMILARITY, 0.42f);
			else
				weights.put(Constants.COMPARISON_STRATEGIES.STRATEGY_COSINE_SIMILARITY, 1f);	
		}
		
	
	return weights;
	}

}
