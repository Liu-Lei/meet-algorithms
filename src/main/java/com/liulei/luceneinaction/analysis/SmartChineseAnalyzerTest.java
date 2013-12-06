package com.liulei.luceneinaction.analysis;
import com.liulei.luceneinaction.Test;
import junit.framework.TestCase;
import org.apache.lucene.analysis.cn.smart.hhmm.HHMMSegmenter;
import org.apache.lucene.analysis.cn.smart.hhmm.SegToken;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liulei
 * Date: 13-12-6
 * Time: 上午10:53
 * To change this template use File | Settings | File Templates.
 */
public class SmartChineseAnalyzerTest extends TestCase{
    public static void main(String[] args) {
        HHMMSegmenter segmenter = new HHMMSegmenter();
        List<SegToken> segTokenList = segmenter.process("冠心病");
        for(SegToken token : segTokenList){
            System.out.println(token.charArray);
        }
    }
    public void testSmartChineseAnalyzer(){
        System.out.println("Test");
    }
}
