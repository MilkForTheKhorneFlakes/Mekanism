package mekanism.common.advancements.triggers;

import com.google.gson.JsonObject;
import java.util.Optional;
import mekanism.api.functions.ConstantPredicates;
import mekanism.common.advancements.MekanismCriteriaTriggers;
import net.minecraft.advancements.critereon.AbstractCriterionTriggerInstance;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.DeserializationContext;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

public class UnboxCardboardBoxTrigger extends SimpleCriterionTrigger<UnboxCardboardBoxTrigger.TriggerInstance> {
    @NotNull
    @Override
    protected TriggerInstance createInstance(@NotNull JsonObject json, @NotNull Optional<ContextAwarePredicate> playerPredicate, @NotNull DeserializationContext context) {
        return new TriggerInstance(playerPredicate);
    }

    public void trigger(ServerPlayer player) {
        this.trigger(player, ConstantPredicates.alwaysTrue());
    }

    public static class TriggerInstance extends AbstractCriterionTriggerInstance {

        public TriggerInstance(Optional<ContextAwarePredicate> playerPredicate) {
            super(playerPredicate);
        }

        public static UnboxCardboardBoxTrigger.TriggerInstance unbox() {
            return new UnboxCardboardBoxTrigger.TriggerInstance(Optional.empty());
        }
    }
}