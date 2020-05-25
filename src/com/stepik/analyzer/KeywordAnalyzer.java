package com.stepik.analyzer;

public abstract class KeywordAnalyzer implements TextAnalyzer{

    protected abstract String[] getKeywords();

    protected abstract Label getLabel();

    @Override
    public Label processText(String text) {
        for (String keywords : getKeywords()) {
            if (text.matches(".*" + keywords + ".*")) {return getLabel();}
        }
        return Label.OK;
    }
}
