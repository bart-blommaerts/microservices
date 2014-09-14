package be.daggie.microservices.async;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.SimpleMessageConverter;

public class CorrelationIdMessageConverter extends SimpleMessageConverter {
	private String correlationId = null;
	
	@Override
	protected Message createMessage(Object object, MessageProperties messageProperties)
			throws MessageConversionException {
		messageProperties.setCorrelationId(correlationId.getBytes());
		
		return super.createMessage(object, messageProperties);
	}
	
	public String getCorrelationId() {
		return correlationId;
	}
	
	public void setCorrellationId(String correlationId) {
		this.correlationId = correlationId;
	}
}
