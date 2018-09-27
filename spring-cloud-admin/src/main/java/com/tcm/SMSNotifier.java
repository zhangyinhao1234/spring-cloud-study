package com.tcm;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import de.codecentric.boot.admin.event.ClientApplicationEvent;
import de.codecentric.boot.admin.notify.AbstractStatusChangeNotifier;

public class SMSNotifier extends AbstractStatusChangeNotifier {

    private Log logger = LogFactory.getLog(getClass());
    private static final String DEFAULT_TEXT = "#{application.name} (#{application.id}) 状态变更  from #{from.status} to #{to.status}#{application.healthUrl}";
    private final SpelExpressionParser parser = new SpelExpressionParser();
    private Expression text;

    public SMSNotifier() {
        this.text = parser.parseExpression(DEFAULT_TEXT, ParserContext.TEMPLATE_EXPRESSION);
    }

    /**
     * 发送短息你的目标手机号
     */
    private String[] to;
    /**
     * 不需要通知的状态变动
     */
    private String[] ignoreChanges = new String[] { "UNKNOWN:UP", "OFFLINE:UP", "UNKNOWN:OFFLINE" };
    
    @Override
    protected void doNotify(ClientApplicationEvent event) throws Exception {
        super.setIgnoreChanges(ignoreChanges);
        boolean shouldNotify = super.shouldNotify(event);
        if (shouldNotify) {
            sendMsg(event);
        }
    }

    private void sendMsg(ClientApplicationEvent event) {
        String smsContent = getSmsContent(event);
        logger.info("短息内容：" + smsContent+"到手机号："+to);
        // 发送短信API TODO
    }

    /**
     * 封装信息消息体
     */
    private String getSmsContent(ClientApplicationEvent event) {
        EvaluationContext context = new StandardEvaluationContext(event);
        parser.parseExpression(DEFAULT_TEXT, ParserContext.TEMPLATE_EXPRESSION);
        return text.getValue(context, String.class);
    }

    public String[] getTo() {
        return to;
    }

    public void setTo(String[] to) {
        this.to = to;
    }

    public String[] getIgnoreChanges() {
        return ignoreChanges;
    }

    public void setIgnoreChanges(String[] ignoreChanges) {
        this.ignoreChanges = ignoreChanges;
    }
    
    
    
}
