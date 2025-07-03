package controllers;

import play.libs.Json;
import play.mvc.Result;
import play.mvc.Results;

import java.util.HashMap;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.io.File;

public class IndexController extends BaseController
{
	public CompletionStage<Result> index()
	{
		return computeAsync().thenApplyAsync(string -> ok(string));
	}

	public CompletionStage<Result> indexv2()
	{
		return CompletableFuture.supplyAsync(() -> { return "HELLO_V2"; }).thenApplyAsync(string -> ok(string));
	}

	public static CompletionStage<String> computeAsync()
	{
		return CompletableFuture.completedFuture("HELLO");
	}

	public Result file()
	{
		return ok(new File("/Users/quikr/Desktop/harvard mails/bucket1.html"));
	}

	public Result fileAsAttachment()
	{
		return ok(new File("/Users/quikr/Desktop/harvard mails/bucket1.html"), false);
	}

	public CompletionStage<Result> get(String input)
	{
		return CompletableFuture.completedFuture(Json.toJson(new HashMap<String, String>(){{put("input", input);}})).thenApplyAsync(Results::ok);
	}
}