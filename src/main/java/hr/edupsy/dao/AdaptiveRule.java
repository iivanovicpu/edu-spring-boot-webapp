package hr.edupsy.dao;

import hr.edupsy.controllers.AdaptiveRuleTypes;
import hr.edupsy.controllers.IntelligenceTypes;
import hr.edupsy.controllers.LearningStyles;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author iivanovic
 * @date 12.10.16.
 */
@AllArgsConstructor
@Data
public class AdaptiveRule {
    private int id;
    private int learningStyleId;
    private int intelligenceTypeId;
    private int ruleId;
    private String ruleData;
    private String mark;

    private String intelligenceDescription;
    private String styleDescription;
    private String ruleDescription;

    public String getIntelligenceDescription() {
        return IntelligenceTypes.getById(this.getIntelligenceTypeId()).getDescription();
    }

    public String getStyleDescription() {
        return LearningStyles.getById(this.getLearningStyleId()).getDescription();
    }

    public String getRuleDescription() {
        return AdaptiveRuleTypes.getById(this.getRuleId()).getDescription();
    }

}
