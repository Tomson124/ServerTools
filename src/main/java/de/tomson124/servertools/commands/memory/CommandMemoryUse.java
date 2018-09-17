package de.tomson124.servertools.commands.memory;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class CommandMemoryUse extends CommandBase {

	public CommandMemoryUse() {
	}

	@Override
	public String getName() {
		return "memory";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return null;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		Runtime runtime = Runtime.getRuntime();

		long maxMemory = convertToMB(runtime.maxMemory());
		long freeMemory = convertToMB(runtime.freeMemory());
		long totalMemory = convertToMB(runtime.totalMemory());

		long usedMemory = totalMemory - freeMemory;

		sender.sendMessage(new TextComponentString("RAM-TEST-USE: " + usedMemory));

	}

	private long convertToMB(long bytes) {
		return bytes / 1024 / 1024;
	}
}
