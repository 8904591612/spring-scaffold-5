package br.com.netodevel.scaffold;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.boot.cli.command.HelpExample;
import org.springframework.boot.cli.command.OptionParsingCommand;
import org.springframework.boot.cli.command.options.OptionHandler;

public class ClientSidePaginationCommand extends OptionParsingCommand  {

	public ClientSidePaginationCommand(String name, String description,
			OptionHandler handler) {
		super(name, description, handler);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getUsageHelp() {
		return "[name-model] [parameters-model]";
	}
	
	@Override
	public Collection<HelpExample> getExamples() {
		List<HelpExample> list = new ArrayList<HelpExample>();
		list.add(new HelpExample("create client side pagination api kotlin", "clientsidepagination -n User -p name:String -l kotlin"));
		list.add(new HelpExample("create client side pagnation api java", "clientsidepagination -n User -p name:String -l java"));
		return list;
	}

}
