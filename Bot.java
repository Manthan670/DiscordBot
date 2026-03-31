import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Bot extends ListenerAdapter {
    
    public static void main(String[] args) {
        String token = "MTQ4Nzg1MjM1NDgxNTM5ODEzOA.Gz4_jm.zXzY7u7axoQrsVflPk1YbmGzP5LVZZ9znart_U";  // Here the token needs to be added, the tokan needs to be invoked from discord development. Taking oAuth2 needs to be compileted first at https://discord.com/developers/applications/ .
        
        try {
            JDABuilder.createLight(token, 
                GatewayIntent.GUILD_MESSAGES,
                GatewayIntent.MESSAGE_CONTENT)
                .addEventListeners(new Bot())
                .setActivity(Activity.playing("Type !ping"))
                .build();
            
            System.out.println("Bot is online!\nPress Ctrl+C to stop");
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        
        String message = event.getMessage().getContentDisplay();
        
        if (message.equalsIgnoreCase("!ping")) {
            event.getChannel().sendMessage("Pong! ^-^").queue();
            System.out.println("Responded to !ping from " + event.getAuthor().getName());
        }

        else if (message.equalsIgnoreCase("!hello")) {
            event.getChannel().sendMessage("Hello " + event.getAuthor().getName() + "! :D").queue();
        }

        else if (message.equalsIgnoreCase("!help")) {
            event.getChannel().sendMessage("""
                **Available Commands:**
                `!ping` - Check if bot is alive
                `!hello` - Get a greeting
                `!help` - Show this message
                """).queue();
        }
        else if (message.equalsIgnoreCase("!time")) {
            event.getChannel().sendMessage(" Current time: " + java.time.LocalDateTime.now()).queue();
        }
        else if (message.equalsIgnoreCase("!userinfo")) {
    event.getChannel().sendMessage(
        "User: " + event.getAuthor().getName() +
        "\nID: " + event.getAuthor().getId()
    ).queue();
}

else if (message.equalsIgnoreCase("!serverinfo")) {
    event.getChannel().sendMessage(
        "Server: " + event.getGuild().getName() +
        "\nMembers: " + event.getGuild().getMemberCount()
    ).queue();
}

else if (message.equalsIgnoreCase("!avatar")) {
    event.getChannel().sendMessage(
        event.getAuthor().getAvatarUrl()
    ).queue();
}

else if (message.equalsIgnoreCase("!uptime")) {
    long uptime = java.lang.management.ManagementFactory.getRuntimeMXBean().getUptime();
    event.getChannel().sendMessage("Uptime: " + uptime / 1000 + " seconds").queue();
}

else if (message.equalsIgnoreCase("!random")) {
    int num = new java.util.Random().nextInt(100);
    event.getChannel().sendMessage("Random number: " + num).queue();
}

else if (message.startsWith("!say ")) {
    String text = message.substring(5);
    event.getChannel().sendMessage(text).queue();
}

else if (message.equalsIgnoreCase("!clear")) {
    event.getChannel().sendMessage("Clear command requires permissions & bulk delete setup.").queue();
}

else if (message.equalsIgnoreCase("!date")) {
    event.getChannel().sendMessage("Today: " + java.time.LocalDate.now()).queue();
}

else if (message.equalsIgnoreCase("!servericon")) {
    event.getChannel().sendMessage(event.getGuild().getIconUrl()).queue();
}

else if (message.equalsIgnoreCase("!botinfo")) {
    event.getChannel().sendMessage("Bot running using JDA.").queue();
}

else if (message.equalsIgnoreCase("!channel")) {
    event.getChannel().sendMessage("Channel: " + event.getChannel().getName()).queue();
}

else if (message.equalsIgnoreCase("!id")) {
    event.getChannel().sendMessage("Your ID: " + event.getAuthor().getId()).queue();
}

else if (message.equalsIgnoreCase("!roles")) {
    event.getChannel().sendMessage(
        "Roles: " + event.getMember().getRoles().toString()
    ).queue();
}

else if (message.equalsIgnoreCase("!pingms")) {
    event.getJDA().getRestPing().queue(ping ->
        event.getChannel().sendMessage("Ping: " + ping + "ms").queue()
    );
}

else if (message.equalsIgnoreCase("!repeat")) {
    event.getChannel().sendMessage("Repeat what? Use !say <text>").queue();
}
else if (message.equalsIgnoreCase("!membercount")) {
    event.getChannel().sendMessage(
        "Total members: " + event.getGuild().getMemberCount()
    ).queue();
}

else if (message.equalsIgnoreCase("!owner")) {
    event.getChannel().sendMessage(
        "Server Owner: " + event.getGuild().getOwner().getUser().getName()
    ).queue();
}

else if (message.equalsIgnoreCase("!created")) {
    event.getChannel().sendMessage(
        "Server created on: " + event.getGuild().getTimeCreated()
    ).queue();
}

else if (message.equalsIgnoreCase("!join")) {
    event.getChannel().sendMessage(
        "You joined on: " + event.getMember().getTimeJoined()
    ).queue();
}

else if (message.equalsIgnoreCase("!boosts")) {
    event.getChannel().sendMessage(
        "Boost count: " + event.getGuild().getBoostCount()
    ).queue();
}

else if (message.equalsIgnoreCase("!region")) {
    event.getChannel().sendMessage(
        "Region: " + event.getGuild().getLocale()
    ).queue();
}

else if (message.equalsIgnoreCase("!emojis")) {
    event.getChannel().sendMessage(
        "Emoji count: " + event.getGuild().getEmojis().size()
    ).queue();
}

else if (message.equalsIgnoreCase("!textchannels")) {
    event.getChannel().sendMessage(
        "Text channels: " + event.getGuild().getTextChannels().size()
    ).queue();
}

else if (message.equalsIgnoreCase("!voicechannels")) {
    event.getChannel().sendMessage(
        "Voice channels: " + event.getGuild().getVoiceChannels().size()
    ).queue();
}

else if (message.equalsIgnoreCase("!categorycount")) {
    event.getChannel().sendMessage(
        "Categories: " + event.getGuild().getCategories().size()
    ).queue();
}

else if (message.equalsIgnoreCase("!nickname")) {
    String nick = event.getMember().getNickname();
    event.getChannel().sendMessage(
        nick != null ? "Your nickname: " + nick : "No nickname set"
    ).queue();
}

else if (message.equalsIgnoreCase("!status")) {
    event.getChannel().sendMessage(
        "Your status: " + event.getMember().getOnlineStatus().name()
    ).queue();
}

else if (message.equalsIgnoreCase("!rolescount")) {
    event.getChannel().sendMessage(
        "Total roles: " + event.getGuild().getRoles().size()
    ).queue();
}

else if (message.equalsIgnoreCase("!isbot")) {
    event.getChannel().sendMessage(
        "Are you a bot? " + event.getAuthor().isBot()
    ).queue();
}

else if (message.equalsIgnoreCase("!userid")) {
    event.getChannel().sendMessage(
        "User ID: " + event.getAuthor().getIdLong()
    ).queue();
}
    }
}