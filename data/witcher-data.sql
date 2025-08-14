-- Witcher Microservices - Sample Data
-- Items and Monsters from The Witcher Universe

-- ITEMS DATA
INSERT INTO items (name, description, item_type, price) VALUES
-- SWORDS
('Silver Sword', 'A silver blade forged specifically for hunting monsters. Essential for any witcher.', 'SWORD', 500.00),
('Steel Sword', 'A well-crafted steel sword for fighting humans and non-magical creatures.', 'SWORD', 300.00),
('Aerondight', 'A legendary silver sword that grows stronger with each enemy slain.', 'SWORD', 2000.00),
('Iris', 'An enchanted steel sword with a tragic history, once belonging to Olgierd von Everec.', 'SWORD', 1500.00),

-- ARMOR
('Griffin School Armor', 'Medium armor favored by Griffin School witchers, balancing protection and mobility.', 'ARMOR', 800.00),
('Cat School Armor', 'Light armor preferred by Cat School witchers for maximum agility.', 'ARMOR', 600.00),
('Wolf School Armor', 'The iconic armor of the Wolf School, worn by Geralt of Rivia.', 'ARMOR', 1000.00),
('Ursine Armor', 'Heavy armor of the Bear School, providing maximum protection.', 'ARMOR', 1200.00),

-- POTIONS
('Swallow', 'A healing potion that regenerates vitality over time. Essential for survival.', 'POTION', 50.00),
('Cat', 'Enhances night vision, allowing witchers to see in complete darkness.', 'POTION', 40.00),
('Thunderbolt', 'Increases attack power and critical hit chance during combat.', 'POTION', 60.00),
('Quen', 'Creates a protective shield that absorbs incoming damage.', 'POTION', 45.00),
('White Raffard''s Decoction', 'An instant healing potion for emergency situations.', 'POTION', 80.00),

-- OILS
('Necrophage Oil', 'Applied to silver swords to increase damage against necrophages.', 'OIL', 30.00),
('Specter Oil', 'Enhances silver sword effectiveness against spectral enemies.', 'OIL', 35.00),
('Beast Oil', 'Increases damage dealt to wild beasts and monsters.', 'OIL', 25.00),
('Draconid Oil', 'Specially formulated to harm dragons and dragonlings.', 'OIL', 40.00),

-- MONSTER PARTS
('Griffin Feathers', 'Rare feathers from a griffin, used in advanced alchemy.', 'MONSTER_PART', 100.00),
('Nekker Heart', 'The heart of a nekker, valuable for potion brewing.', 'MONSTER_PART', 75.00),
('Drowner Brain', 'Brain tissue from a drowner, used in various alchemical recipes.', 'MONSTER_PART', 20.00),
('Vampire Dust', 'Powdered remains of a vampire, extremely rare and valuable.', 'MONSTER_PART', 200.00);

-- MONSTERS DATA
INSERT INTO monsters (name, description, monster_type, weakness, habitat, danger_level) VALUES
-- NECROPHAGES
('Ghoul', 'Scavenging creatures that feed on corpses. Often found in battlefields and cemeteries.', 'NECROPHAGE', 'Necrophage Oil, Igni Sign', 'Battlefields, Cemeteries', 3),
('Drowner', 'Aquatic necrophages that drag victims underwater to drown them.', 'NECROPHAGE', 'Necrophage Oil, Igni Sign', 'Swamps, Rivers, Lakes', 2),
('Rotfiend', 'Bloated necrophages that explode when near death, spreading disease.', 'NECROPHAGE', 'Necrophage Oil, Keep Distance', 'Sewers, Swamps', 4),

-- SPECTERS
('Wraith', 'Vengeful spirits of those who died violently, bound to the mortal realm.', 'SPECTER', 'Specter Oil, Yrden Sign, Moon Dust', 'Abandoned Places, Battlefields', 5),
('Noonwraith', 'Spirits that appear during midday, born from women who died in fields.', 'SPECTER', 'Specter Oil, Yrden Sign', 'Fields, Meadows', 4),
('Nightwraith', 'Nocturnal spirits that haunt the places of their death.', 'SPECTER', 'Specter Oil, Yrden Sign', 'Cemeteries, Ruins', 5),

-- BEASTS
('Wolf', 'Wild wolves that hunt in packs, dangerous when cornered.', 'BEAST', 'Beast Oil, Axii Sign', 'Forests, Mountains', 2),
('Bear', 'Massive predators with incredible strength and thick hide.', 'BEAST', 'Beast Oil, Quen Sign', 'Forests, Caves', 4),
('Griffin', 'Majestic flying predators with the body of a lion and wings of an eagle.', 'BEAST', 'Crossbow, Aard Sign', 'Mountains, Cliffs', 7),

-- DRACONIDS
('Forktail', 'Lesser dragons with venomous breath and razor-sharp claws.', 'DRACONID', 'Draconid Oil, Golden Oriole', 'Mountains, Caves', 6),
('Wyvern', 'Two-legged dragons known for their speed and agility in flight.', 'DRACONID', 'Draconid Oil, Crossbow', 'High Mountains', 5),

-- VAMPIRES
('Katakan', 'Higher vampires capable of shapeshifting and incredible regeneration.', 'VAMPIRE', 'Black Blood, Moon Dust', 'Cities, Sewers', 8),
('Ekimmara', 'Vampires that drain life force through physical contact.', 'VAMPIRE', 'Black Blood, Igni Sign', 'Caves, Ruins', 6),

-- CURSED ONES
('Werewolf', 'Humans cursed to transform into savage wolf-like beasts.', 'CURSED_ONE', 'Cursed Oil, Moon Dust', 'Forests, Villages', 5),
('Botchling', 'The cursed spirit of an unwanted child, twisted by neglect.', 'CURSED_ONE', 'Cursed Oil, Axii Sign', 'Villages, Homes', 4),

-- HYBRIDS
('Succubus', 'Seductive creatures that feed on life energy through intimate contact.', 'HYBRID', 'Hybrid Oil, Quen Sign', 'Cities, Brothels', 3),
('Doppler', 'Shapeshifters capable of perfectly mimicking other beings.', 'HYBRID', 'Hybrid Oil, Careful Observation', 'Cities, Anywhere', 4),

-- RELICTS
('Leshen', 'Ancient forest guardians with power over nature and animals.', 'RELICT', 'Relict Oil, Dimeritium Bombs', 'Ancient Forests', 9),
('Fiend', 'Massive deer-like creatures with hypnotic powers and incredible strength.', 'RELICT', 'Relict Oil, Samum Bombs', 'Deep Forests', 7),

-- INSECTOIDS
('Kikimore', 'Giant insect-like creatures that live in underground colonies.', 'INSECTOID', 'Insectoid Oil, Igni Sign', 'Caves, Underground', 5),
('Endrega', 'Aggressive insectoids with powerful mandibles and venomous stingers.', 'INSECTOID', 'Insectoid Oil, Aard Sign', 'Caves, Ruins', 4);