import pandas as pd
from mlxtend.frequent_patterns import apriori, association_rules
from mlxtend.preprocessing import TransactionEncoder

transactions = [['Dog','Parrot'],
                ['Dog','Fish','Rabbit','Cat'],
                ['Parrot','Fish','Rabbit','Hamster'],
                ['Dog','Parrot','Fish','Rabbit'],
                ['Dog','Parrot','Fish','Hamster']]

te = TransactionEncoder()
te_array=te.fit(transactions).transform(transactions)
df = pd.DataFrame(te_array, columns=te.columns_)
print(df)

freq_items = apriori(df,min_support =0.8, use_colnames=True)
print("\n\nFREQUENT ITEMSETS\n\n")
print(freq_items)

rules = association_rules(freq_items, metric='support', min_threshold=0.05)
print("\n\nMining Association Rules\n\n")
rules = rules.sort_values(['support','confidence'],ascending=[False,False])
print(rules)
