package me.xmrvizzy.skyblocker.config.categories;

import dev.isxander.yacl3.api.ConfigCategory;
import dev.isxander.yacl3.api.Option;
import dev.isxander.yacl3.api.OptionDescription;
import dev.isxander.yacl3.api.controller.BooleanControllerBuilder;
import dev.isxander.yacl3.api.controller.StringControllerBuilder;
import me.xmrvizzy.skyblocker.config.ConfigModel;
import me.xmrvizzy.skyblocker.config.ConfigUtils;
import net.minecraft.text.Text;

public class DiscordRPCCategory {

	public static ConfigCategory create(ConfigModel defaults, ConfigModel config) {
		return ConfigCategory.createBuilder()
				.name(Text.translatable("text.autoconfig.skyblocker.category.richPresence"))
				
				//Uncategorized Options
				.option(Option.<Boolean>createBuilder()
						.name(Text.translatable("text.autoconfig.skyblocker.option.richPresence.enableRichPresence"))
						.binding(defaults.richPresence.enableRichPresence,
								() -> config.richPresence.enableRichPresence,
								newValue -> config.richPresence.enableRichPresence = newValue)
						.controller(BooleanControllerBuilder::create)
						.build())
				.option(Option.<ConfigModel.Info>createBuilder()
						.name(Text.translatable("text.autoconfig.skyblocker.option.richPresence.info"))
						.description(OptionDescription.of(Text.translatable("text.autoconfig.skyblocker.option.richPresence.info.@Tooltip")))
						.binding(defaults.richPresence.info,
								() -> config.richPresence.info,
								newValue -> config.richPresence.info = newValue)
						.controller(ConfigUtils::createCyclingListController4Enum)
						.build())
				.option(Option.<Boolean>createBuilder()
						.name(Text.translatable("text.autoconfig.skyblocker.option.richPresence.cycleMode"))
						.binding(defaults.richPresence.cycleMode,
								() -> config.richPresence.cycleMode,
								newValue -> config.richPresence.cycleMode = newValue)
						.controller(BooleanControllerBuilder::create)
						.build())
				.option(Option.<String>createBuilder()
						.name(Text.translatable("text.autoconfig.skyblocker.option.richPresence.customMessage"))
						.binding(defaults.richPresence.customMessage,
								() -> config.richPresence.customMessage,
								newValue -> config.richPresence.customMessage = newValue)
						.controller(StringControllerBuilder::create)
						.build())
				.build();
	}
}
