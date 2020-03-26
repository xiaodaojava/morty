package com.platform.oecp.admin.test;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.io.StringReader;

/**
 * @version 1.0
 * @className: IkanalyzerTest
 * @author: LILIANG
 * @date: Create In 2020/3/27 0:13
 * @description:
 */
public class IkanalyzerTest {

    public static void main(String[] args) throws IOException {
        String text="基于java语言开发的轻量级的中文分词工具包";
        StringReader sr=new StringReader(text);
        IKSegmenter ik=new IKSegmenter(sr, true);
        Lexeme lex=null;
        while((lex=ik.next())!=null){
            System.out.print(lex.getLexemeText()+"|");
        }
    }

}
