package com.project.redditclone.service;

import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
@Service
public class MailContentBuilder {
	private final TemplateEngine templateEngine;

	public MailContentBuilder(TemplateEngine templateEngine) {
		super();
		this.templateEngine = templateEngine;
	}
	String build(String message) {
		Context context = new Context();
		context.setVariable("message", message);
		return templateEngine.process("mailTemplate", context);
	}
}
