//1 index for cardName, sceneNumberAndBudget (ex. {0,0}), and scene = 3 roles and role levels
//0 is basically null

//1 location/marker(s), 4 parts/lines/levels/neighbors per location, 
public class Get_Info {
	
	
	
	//-----------------------------------------------card info-----------------------------------------------------------------------------------------------
		public static String [] cardName = {"Evil Wears A Hat", 
						 "Law and the Old West",
						 "The Life and Times of John Skywater",
						 "My Years on the Prairie",
						 "Buffalo Bill: The Lost Years",
						 "Square Deal City",
						 "Davy Crockett: A Drunkard's Tale",
						 "The Way the West Was Run",
						 "Down in the Valley",
						 "01' Shooter and Little Doll",
						 "The Robbers of Trains",
						 "Beyond the Pail: Life without Lactose",
						 "A Man Called 'Cow'",
						 "Taffy Commercial",
						 "Gum Commercial",
						 "Jesse James: Man of Action",
						 "Disaster at Flying J",
						 "Shakespear in Lubbock",
						 "Go West, You!",
						 "The Life and Times of John Skywater",
						 "Gun! The Musical",
						 "Humor at the Expense of Others",
						 "The Search for Maggie White",
						 "Picante Sauce Commercial",
						 "Jesse James: Man of Action",
						 "One False Step for Mankind",
						 "Thirteen the Hard Way",
						 "How They Get Milk",
						 "My Years on the Prairie",
						 "Davy Crockett: A Drunkard's Tale",
						 "Czechs in the Sonora",
						 "Swing 'em Wide",
						 "Swing 'em Wide",
						 "Trails of the First Pioneers",
						 "How the Grinch Stole Texas",
						 "J. Robert Lucky, Man of Substance",
						 "Thirteen the Hard Way",
						 "How They Get Milk",
						 "Breakin' in Trick Ponies",
						 "Custer's Other Stands"}; //1 card
	 public static int[] sceneNumber = {7, 20, 22, 32, 12, 14, 31, 34, 24, 14, 19, 12, 16, 2, 3, 8, 6, 23, 30, 15, 25, 16, 12, 1, 14, 21, 15, 2, 27, 12, 25, 19, 35, 5, 9, 13, 17, 8, 19, 40};
	 public static int[] budget = {4, 3, 5, 5, 4, 6, 4, 4, 3, 4, 4, 2, 3, 2, 2, 5, 5, 3, 3, 5, 6, 5, 6, 2, 5, 6, 5, 4, 5, 4, 4, 6, 6, 4, 5, 4, 5, 4, 3, 5}; // 1 scene and 1 budget
	 public static String[] scene = {"Calhoun is seperated from the group during a white-knuckled chase near Desperation Bluff.", 
					  "Charlie 'Three Guns' Henderson cooperates with Johnny Law and reluctantly enters the witless protection program.",
					  "Disheartened by his lack of business acumen and his poor choice of investment partners, John Skywater sets off into the Cree Nation to convince them to kidnap his wife.",
					  "Virgil and Stacy set out at midnight to track down the stray cows, unaware that they are being pursued by inch-high aliens from outer space.",
					  "Buffalo Bill's companion Marty disappears in a freak electrical storm. Bill enlists the aid of the Sidekick Friends network.",
					  "Douglas and Katherine confront Aunt Martha about her missing pies. Devin sulks quietly in a side room.",
					  "Robert enlists the aid of several farm animals in order to ascertain the efficacy of his new hangover remedy.",
					  "Jose explains patiently, but with thinly veiled contempt, the intricacies of Arizona bureaucracy, as though speaking to a simple and distracted child.",
					  "A tripped waiter is the spark igniting a brawl of cataclysmic proportions. Walter is injured in the neck.",
					  "Shooter discovers that he has been proceeding for days with no trousers. This causes him no small embarrassment as he searches for them with Little Doll.",
					  "Coogan confronts the toughest thug in his gang, Big Jake, in an abbreviated knife fight. Coogan settles the dispute with fearless guile and a kick in the family jewels.",
					  "Henry discovers for the first time that his ability to digest cream has disappeared along with his hair. Other cowboys attempt to console him.",
					  "Nothing will settle the debates among the skeptical locals, short of a demonstration of Hector's special talents.",
					  "Jackson encourages the children to eat only taffy, because gum can kill them stone dead.",
					  "Inspector Pete speaks to a riveted audience about the many hidden dangers of taffy, not the least of which is that taffy can kill you stone dead.",
					  "Jesse's brothers Jed and henry throw him a surprise birthday party. Jesse's nevers get the better of him when the birthday cake explodes.",
					  "After the mine explosion, the traveling circus takes time out to get drunk and start a fight.",
					  "William decides that it is time to be movin' on. Julia convinces him to stick around just long enough to get into big trouble.",
					  "Susan and Peter encounter some of the perils of the Badlands: rutted mud roads, torrential rain storms, and a bade case of 'grumbly tummy.'",
					  "John discovers his long-lost sister Marcie, and instructs her in the ways of gunfighting and whiskey distillation.",
					  "A song and dance extravaganza, 'Hunka Hunka Burnin' Lead.'",
					  "Phil and his cohort of unfeeling smart-mouths make fun of Sancho and his great big hat.",
					  "Alone in the wilderness, Maggie makes the best of her situation. In what seems like no time at all, she constructs a sturdy two-story house from branches and mud.",
					  "A dozen grizzled cowboys surround a fire. Suddenly, they exclaim, 'That's not mayonnaise!'",
					  "A hail of gunfire results when Jesse's friend Barton marries Jesse's childhood sweetheart.",
					  "After a dozen failed attempts, one rocket carries Horatio and his six children to the Moon, where they enjoy a picnic and a spirited game of badminton.",
					  "After some delay, the Pony Express arrives. Isaac, Gwen, Francis, Terry, Conrad, Brooke, Jerry, Howard, MacNeill, Jones, Spike, Cornwall and Crawford are all there.",
					  "Josie asks the Milkman how they get milk. After a thoughtful pause, he begins. 'Not like you'd expect!'",
					  "Louise takes instruction from Henry, the neighbor boy, in an absurdly suggestive explanation of how to plow a field.",
					  "In an absurd dream sequence, Crockett recalls an episode of fear and chaos in which his childhood friend Timmy was trapped at the bottom of a well.",
					  "Bob reverts to his ancestral ways in a short fight over a disembodied hand.",
					  "Black Jack invites dixon and The Captain to a late night poker game. Little do they know that Gertrude and Isabella await them at the table.",
					  "Hector makes a surprising discovery behind the Chinese grocery store.",
					  "A fire breaks out in the town livery. Before long, the surrounding buildings are engulfed in flame. The world falls into chaos.",
					  "The doe-eyed citizens of El Paso gather together around a warm fire and pray for the safety of those poor souls in Oklahoma. It almost works.",
					  "Horace and Mathilde discover that the mysterious orange powder filling Doctor Lucky's air vents is neither Agent Orange nor weaponized Tang, but a rare form of cheese mold.",
					  "After operating for only six minutes, the Pony Express disbands and gives way to the International Telegraph and Railroad Systems. Little boys cry.",
					  "Josie is thoroughly off milk at this point. The Milkman shows her one more way that she might not have heard of before.",
					  "Uncle Stewart reveals what to do when all else fails.",
					  "General George Armstrong Custer clinches another victory at the battle of Little Sands. His trusty steed Cairo is not so lucky."};
	
	
	public static String[] part = {"Defrocked Priest", "Marshal Canfield", "One-Eyed Man",
								"Rug Merchant", "Banker", "Talking Mule",
								"Auctioneer", "General Custer", null,
								"Drunk", "Librarian", "Man with Hay",
								"Hollering Boy", "Drink Farmer", "Meek Little Sarah",
								"Squaking Boy", "Pharaoh Imhotep", "Aunt Martha",
								"The Duck", "His Brother", null,
								"Town Drunk", "Squinting Miner", "Poltergeist",
								"Angry Barber", "Woman with Board", "Man in Fire",
								"Sleeping Man", "Man with Pig", "Shooter",
								"Buster", "Man Reading Paper", "Fat Pete",
								"Martin", null, null,
								"Preacher", "Amused Witness", null,
								"Curious girl", "Ghost of Plato", null,
								"Surprised Bison", "Man with Horn", null,
								"Shot in Back", "Shot in Leg", "Leaps into Cake",
								"Piano Player", "Man in Turban", "Falls on Hoe",
								"Falls from Tree", "Laughing Woman", "Man with Whistle",
								"Ex-Convict", "Man with Onion", null,
								"Staggering Man", "Woman with Beer", "Marcie",
								"Looks like Elvis", "Singing Dead Man", "Apothecary",
								"Jailer", "Mephistopheles", "Breaks a Window",
								"Film Critic", "Hobo with Bat", null,
								"Bewhisker'd Cowpoke", "Dog", null,
								"Shot in Head", "Leaps Out of Cake", "Shot Three Times",
								"Flustered Man", "Space Monkey", "Cowbot Dan",
								"Man in Poncho", "Ecstatic Housewife", "Isaac",
								"Cow", "St. Clement of Alexandria", "Josie",
								"Willard", "Leprechaun", "Startled Ox",
								"Voice of God", "Hands of God", "Jack Kemp",
								"Opice (Monkey)", "Man with Gun", null,
								"Thrifty Mike", "Sober Physician", "Man on Floor",
								"Liberated Nun", "Witch Doctor", "Voice of Reason",
								"Burning Man", "Cheese Vendor", "Hit with Table",
								"Detective", "File Clerk", "Cindy Lou",
								"Man with Rope", "Svetlana", "Accidental Victim",
								"Very Wet Man", "Dejected Housewife", "Man with Box",
								"Marksman", "Postal Worker", "A Horse",
								"Fraternity Pledge", "Man with Sword", null,
								"Farmer", "Exploding Horse", "Jack"}; 
			
    public static String[] line = 	 {"Look out below!", "Hold fast!", "Balderdash!",
								 "Don't leave my store!", "Trust me", "Nice work, Johnny!",
								 "Going Once!", "Go West!", null,
								 "Where's Willard?", "Shhhhh!", "Hey!",
								 "Over here, mister!", "Git outta me barn!", "He's so cute!",
								 "I'll say!", "Attack, soldiers!", "You got nothin'!",
								 "Waaaak!", "Waaaaaaaak!", null,
								 "Even me!", "Sure we can!", "Wooooo!",
								 "Hold him still!", "Nonsense, Frank!", "It burns!",
								 "Snnkkk snnkk snnkk", "Tally-Hooo!", "Where's my britches?",
								 "One two three go!", "Ouchie!", "Nick kick, boss!",
								 "Have you tried soy cheese?", null, null,
								 "My word!", "Tee hee hee!", null,
								 "Are you sure?", "It happened to me!", null,
								 "Mmrrrrrph!","Ta daaaa!", null,
								 "Arrrggh", "Ooh, lordy!", "Dangit, Jesse!",
								 "It's a nocturne!", "My stars!", "Ow!",
								 "What ho!", "Tis to laugh!", "Tweeeeet!",
								 "Never again!", "Fresh Onions!", null,
								 "You never know!", "Howdy, stranger!", "Welcome home!",
								 "Thankyouverymuch.", "Yeah!", "Such drugs I have.",
								 "You there!", "Be not afraid!", "Oops!",
								 "Implausible!", "Nice house!", null,
								 "Oh, sweet Lord!", "Wurf!", null,
								 "Arrrgh!", "Oh, for Pete's sake!", "Ow! Ow! Ow!",
								 "Well, I never!", "Ook!", "Bzzzzzt!",
								 "Howdy, Jones!", "This is fine!", "The mail!",
								 "Moo.", "Peace be with you, child!", "Yikes!",
								 "Ain't that a sight?", "Begorrah", "Mrr?",
								 "Grab hold, son!", "!", "America!",
								 "Ukk! (Ook)!", "Hold it right there!", null,
								 "Call!", "Raise!", "Fold!",
								 "Let me have it!", "Oogie Boogie", "Come on, now!",
								 "Make it stop!", "Opa!", "Ow! A table?",
								 "I have a hunch.", "My stapler!", "Dear Lord!",
								 "Look out below!", "Says who?", "Ow! My spine!",
								 "Sheesh!", "Its time had come.", "Progress!",
								 "Pull!", "It's about time!", "Yes Sir!",
								 "Beer me!", "None shall pass!", null,
								 "Git off a that!", "Boom!", "Here we go again!"}; //3 roles/lines
	public static int[] roleLevel = {2, 3, 4,
					   1, 2, 4,
					   5, 6, 0,
					   3, 4, 6,
					   2, 3, 5,
					   2, 4, 6,
					   4, 6, 0,
					   2, 4, 5,
					   1, 3, 5,
					   1, 2, 4,
					   1, 4, 5,
					   6, 0, 0,
					   3, 6, 0,
					   3, 4, 0,
					   2, 4, 0,
					   2, 4, 5,
					   2, 3, 4,
					   1, 3, 4,
					   4, 6, 0,
					   3, 5, 6,
					   4, 5, 6,
					   2, 4, 5,
					   5, 6, 0,
					   3, 6, 0,
					   1, 4, 6,
					   1, 2, 5,
					   1, 3, 5,
					   2, 3, 4,
					   2, 3, 5,
					   2, 3, 4,
					   5, 6, 0,
					   1, 3, 5,
					   3, 5, 6,
					   2, 4, 5,
					   3, 4, 5,
					   1, 2, 5,
					   2, 4, 5,
					   4, 5, 6,
					   2, 6, 0,
					   2, 4, 6}; //3 levels
	
	
	
	//-------------------------------------------board info----------------------------------------------------------------------------------------------
		public static String[] location = {"Train Station",
							 "Secret Hideout",
							 "Church",
							 "Hotel",
							 "Main Street",
							 "Jail",
							 "General Store",
							 "Ranch",
							 "Bank",
							 "Saloon",
							 "Trailers",
							 "Casting Office"};

		public static String[] neighbor = {"Jail", "General Store", "Casting Office", null,
							 "Church", "Ranch", "Casting Office", null,
							 "Secret Hideout", "Bank", "Hotel", null,
							 "Trailers", "Bank", "Church", null,
							 "Trailers", "Jail", "Saloon", null,
							 "Main Street", "General Store", "Train Station", null,
							 "Ranch", "Train Station", "Jail", "Saloon",
							 "Casting Office", "General Store", "Secret Hideout", "Bank",
							 "Saloon", "Church", "Ranch", "Hotel",
							 "Main Street", "General Store", "Bank", "Trailers",
							 "Main Street", "Saloon", "Hotel", null,
							 "Train Station", "Ranch", "Secret Hideout", null};
		
		public static String[][] partsAndLine = {{"Crusty Prospector", "Dragged by Train", "Preacher with Bag", "Cyrus the Gunfighter",
									"Clumsy Pit Fighter", "Thug with Knife", "Dangerous Tom", "Penny, who is lost",
									"Dead Man", "Crying Woman", null, null,
									"Sleeping Drunkard", "Faro Player", "Falls from Balcony", "Australian Bartender",
									"Railroad Worker", "Falls off Roof", "Woman in Black Dress", "Mayor McGinty",
									"Prisoner In Cell", "Feller in Irons", null, null,
									"Man in Overalls", "Mister Keach", null, null,
									"Shot in Leg", "Saucy Fred", "Man Under Horse", null,
									"Suspicious Gentleman", "Flustered Teller", null, null,
									"Reluctant Farmer", "Woman in Red Dress", null, null},
				
				                   {"Aww, peaches!", "Omgeezers!", "The Lord will provide.", "Git to fightin' or git away!",
									"Hit me!", "Meet Suzy, my murderin' knife.", "There's two ways we can do this. . . .", "Oh, wow! for I am lost!",
									". . . .", "Oh, the humanity!", null, null,
									"Zzzzzzz...Whiskey!", "Hit me!", "Arrrgghh!", "What'll it be, mate?",
									"Hit me!", "Aaaaiiiigggghh!", "Well, I'll be!", "People of Deadwood!",
									"Zzzzzzz...Whiskey!", "Ah kilt the wrong man!", null, null,
									"Looks like a storm's comin' in", "Howdy, stranger.", null, null,
									"Ow! Me Leg!", "That's what she said.", "A little help here!", null,
									"Can you be more specific?", "Would you like a large bill, sir?", null, null,
									"I ain't so sure about that!", "Come up and see me!", null, null}};

		public static int[] partLevel = {1, 1, 2, 4,
						   1, 2, 3, 4,
						   1, 2, 0, 0,
						   1, 1, 2, 3,
						   1, 2, 2, 4,
						   2, 3, 0, 0,
						   1, 3, 0, 0,
						   1, 2, 3, 0,
						   2, 3, 0, 0,
						   1, 2, 0, 0};
		
		public static int[] markers = {3, 3, 2, 3, 3, 1, 2, 2, 1, 2}; //assuming that <take> are the shot counters
		
	//----------------------------------actual methods------------------------------------------------------------------------------------	
		//replaces a card name with null
		public void removeCard (int index){
			
			cardName[index] = null;
		}
		//returns/gives a card name
		public String getCardName(int index){
			
		//	if (index == 0){
				
				String card = cardName[index];
				return card;
			//	int sceneNumber = sceneNumberAndBudget[index][index];
			//	int store = index + 2;
			//	while (index <= store) {
			//		String role = partAndLine[index][index];
			//		int level = roleLevel[index];
			//		index++;
					
			//	}
					
			/*}
			else {
				String card = cardName[index];
				int sceneNumber = sceneNumberAndBudget[index][index];
				index = index * 3;
				int store = index + 2;
				while (index <= store) {
					String role = partAndLine[index][index];
					index++;
				}
			}*/
			
		}	
}

